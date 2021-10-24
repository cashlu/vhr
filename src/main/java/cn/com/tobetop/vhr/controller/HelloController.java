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

    /**
     * 测试访问员工基本资料的权限控制是否正确。
     */
    @GetMapping("/employee/basic/hello")
    public String basicInfoTest(){
        return "员工基本资料";
    }

    /**
     * 测试访问员工高级资料的权限控制是否正确。
     */
    @GetMapping("/employee/advanced/hello")
    public String advancedInfoTest(){
        return "员工高级资料";
    }
}
