package cn.com.tobetop.vhr.config.handler;

import cn.com.tobetop.vhr.entity.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Program: vhr
 * @Description: 登出成功后的handler
 * @Author: Cash
 * @Create: 2021-10-25 21:03
 **/

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
        // TODO: 如果要记录用户登出的日志，那么就在这里了！
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
        out.flush();
        out.close();
    }
}
