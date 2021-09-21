package cn.com.tobetop.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: vhr
 * @description: 测试controller
 * @author: Cash
 * @create: 2021-09-21 02:00
 **/

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
