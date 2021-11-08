package cn.com.tobetop.vhr.controller;

import cn.com.tobetop.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: vhr
 * @description: 登录功能相关的controller
 * @author: Cash
 * @create: 2021-09-21 03:00
 **/

@RestController
public class LoginController {

    /**
     * 在Spring Security的配置文件中，配置了登录登录跳转的url是/login，但是后端并不处理任何页面，所以当请求到任何需要登录的
     * 页面时，后端并不控制跳转到登录页面之类的操作，而是给前端返回一个json信息。
     *
     * @return RespBean对象
     */
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录！");
    }
}
