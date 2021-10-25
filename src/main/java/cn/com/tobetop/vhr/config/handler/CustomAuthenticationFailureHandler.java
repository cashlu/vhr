package cn.com.tobetop.vhr.config.handler;

import cn.com.tobetop.vhr.entity.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Program: vhr
 * @Description: 认证失败的handler。
 * @Author: Cash
 * @Create: 2021-10-25 20:59
 **/
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        // HACK: 如果要记录用户登录失败的日志，那么就在这里了！
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        RespBean respBean = RespBean.error("登录失败");
        if (e instanceof LockedException) {
            respBean.setMsg("账户被锁定，请联系管理员！");
        } else if (e instanceof CredentialsExpiredException) {
            respBean.setMsg("密码过期，请联系管理员！");
        } else if (e instanceof AccountExpiredException) {
            respBean.setMsg("账户过期，请联系管理员！");
        } else if (e instanceof DisabledException) {
            respBean.setMsg("账户被禁用，请联系管理员！");
        } else if (e instanceof BadCredentialsException) {
            respBean.setMsg("用户名或密码错误");
        }

        String s = new ObjectMapper().writeValueAsString(respBean);
        out.write(s);
        out.flush();
        out.close();
    }
}
