package cn.com.tobetop.vhr.config.handler;

import cn.com.tobetop.vhr.model.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Program: vhr
 * @Description: 没有认证时，不要重定向的到登录页（会引起跨域错误），而是返回给前端json，让前端自己去处理跳转逻辑。
 * @Author: Cash
 * @Create: 2021-10-25 21:06
 **/
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        // 401是没有认证
        resp.setStatus(401);
        PrintWriter out = resp.getWriter();
        RespBean respBean = RespBean.error("访问失败");
        if (authException instanceof InsufficientAuthenticationException) {
            // 因为定义了status是401，实际上这个msg前端不会显示，前端utils/api.js中，会改写这个输出信息。
            respBean.setMsg("Session失效，请重新登录！");
        }
        String s = new ObjectMapper().writeValueAsString(respBean);
        out.write(s);
        out.flush();
        out.close();
    }
}
