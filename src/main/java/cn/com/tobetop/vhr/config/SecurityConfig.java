package cn.com.tobetop.vhr.config;

import cn.com.tobetop.vhr.config.handler.CustomAuthenticationEntryPoint;
import cn.com.tobetop.vhr.config.handler.CustomAuthenticationFailureHandler;
import cn.com.tobetop.vhr.config.handler.CustomAuthenticationSuccessHandler;
import cn.com.tobetop.vhr.config.handler.CustomLogoutSuccessHandler;
import cn.com.tobetop.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @program: vhr
 * @description: Spring Security的配置类
 * @author: Cash
 * @create: 2021-09-21 00:17
 **/

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;

    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;

    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;

    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Autowired
    CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    /**
     * 认证管理器的配置方法。负责配置与认证相关的信息。例如“内存用户”的信息等。通常用来配置自定义的UserDetailsService类。
     *
     * @param auth 认证管理器对象，负责与认证相关的属性配置。
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 因为要从数据库中查找用户，所以必须指定自定义的Service类，该类实现了loadUserByUsername()方法。
        auth.userDetailsService(hrService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 该方法主要用来配置http资源的访问控制。以及用户登录、登录的handler等。
     *
     * @param http HttpSecurity安全配置器
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 允许基于使用HttpServletRequest限制访问
                .authorizeRequests()
                // 所有请求均要求授权
                //.anyRequest().authenticated()

                // 启用自己定义的，用于验证权限（角色）的过滤器
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(customUrlDecisionManager);
                        o.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return o;
                    }
                })
                .and()
                .formLogin()
                // 可自定义用户名、密码的参数名，默认可以不用定义。
                //.usernameParameter("username")
                //.passwordParameter("password")

                /*
                这里定义了Spring Security处理登录请求的Url是"/doLogin"，因为验证过程是由Spring Security完成的，所以
                我们不需要定义处理"/doLogin"这个请求的controller等，在这里配置该url，就是告诉Spring Security，前端
                会把验证的请求发送到这里url上，让Spring Security去处理。
                 */
                .loginProcessingUrl("/doLogin")


                // 登录成功后，将登录用户信息脱敏后，转换为json格式，封装在RespBean对象中，返回给前端。
                //.successHandler(new AuthenticationSuccessHandler() {
                //    @Override
                //    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                //        // HACK: 如果要记录用户登录的日志，那么就在这里了！
                //        resp.setContentType("application/json;charset=utf-8");
                //        PrintWriter out = resp.getWriter();
                //        Hr hr = (Hr) authentication.getPrincipal();
                //        // 数据脱敏
                //        hr.setPassword(null);
                //        RespBean respBean = RespBean.ok("登陆成功", hr);
                //        String s = new ObjectMapper().writeValueAsString(respBean);
                //        out.write(s);
                //        out.flush();
                //        out.close();
                //    }
                //})
                .successHandler(customAuthenticationSuccessHandler)

                // 登录失败后，给前端返回错误信息。
                //.failureHandler(new AuthenticationFailureHandler() {
                //    @Override
                //    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                //        // HACK: 如果要记录用户登录失败的日志，那么就在这里了！
                //        resp.setContentType("application/json;charset=utf-8");
                //        PrintWriter out = resp.getWriter();
                //        RespBean respBean = RespBean.error("登录失败");
                //        if (e instanceof LockedException) {
                //            respBean.setMsg("账户被锁定，请联系管理员！");
                //        } else if (e instanceof CredentialsExpiredException) {
                //            respBean.setMsg("密码过期，请联系管理员！");
                //        } else if (e instanceof AccountExpiredException) {
                //            respBean.setMsg("账户过期，请联系管理员！");
                //        } else if (e instanceof DisabledException) {
                //            respBean.setMsg("账户被禁用，请联系管理员！");
                //        } else if (e instanceof BadCredentialsException) {
                //            respBean.setMsg("用户名或密码错误");
                //        }
                //
                //        String s = new ObjectMapper().writeValueAsString(respBean);
                //        out.write(s);
                //        out.flush();
                //        out.close();
                //    }
                //})
                .failureHandler(customAuthenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                //.logoutSuccessHandler(new LogoutSuccessHandler() {
                //    @Override
                //    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                //        // TODO: 如果要记录用户登出的日志，那么就在这里了！
                //        resp.setContentType("application/json;charset=utf-8");
                //        PrintWriter out = resp.getWriter();
                //        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
                //        out.flush();
                //        out.close();
                //    }
                //})
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .permitAll()
                .and()
                .csrf().disable()
                // 没有认证时，不要重定向的到登录页（会引起跨域错误），而是返回给前端json，让前端自己去处理跳转逻辑。
                .exceptionHandling()
                //.authenticationEntryPoint(new AuthenticationEntryPoint() {
                //    @Override
                //    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
                //        resp.setContentType("application/json;charset=utf-8");
                //        PrintWriter out = resp.getWriter();
                //        RespBean respBean = RespBean.error("访问失败");
                //        if (authException instanceof InsufficientAuthenticationException) {
                //            respBean.setMsg("请求失败，请联系管理员！");
                //        }
                //        String s = new ObjectMapper().writeValueAsString(respBean);
                //        out.write(s);
                //        out.flush();
                //        out.close();
                //    }
                //})
                .authenticationEntryPoint(customAuthenticationEntryPoint);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /*
        通常我们不会过多的自定义WebSecurity，比较多的是使用ignoring()来忽略SpringSecurity对静态资源的控制。
         */
        web.ignoring().antMatchers("/login");
    }


}

