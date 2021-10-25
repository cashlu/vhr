package cn.com.tobetop.vhr.config.handler;

import cn.com.tobetop.vhr.entity.Hr;
import cn.com.tobetop.vhr.entity.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Program: vhr
 * @Description: 认证成功后的handler。
 * @Author: Cash
 * @Create: 2021-10-25 20:56
 **/

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Hr hr = (Hr) authentication.getPrincipal();
        // 数据脱敏
        hr.setPassword(null);
        RespBean respBean = RespBean.ok("登陆成功", hr);
        String s = new ObjectMapper().writeValueAsString(respBean);
        out.write(s);
        out.flush();
        out.close();
    }
}
