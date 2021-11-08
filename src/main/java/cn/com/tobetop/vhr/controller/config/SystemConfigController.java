package cn.com.tobetop.vhr.controller.config;

import cn.com.tobetop.vhr.model.Menu;
import cn.com.tobetop.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: vhr
 * @description: 系统配置相关的controller
 * @author: Cash
 * @create: 2021-10-13 00:51
 **/

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    /**
     * 根据登录用户的ID，获取该用户具备权限访问的菜单项。
     *
     * @return Menu的List封装。
     */
    @GetMapping("/menu")
    public List<Menu> getMenuByHrId() {
        // 这里一定不能使用前端传过来的HrId，因为不可信。
        return menuService.getMenuByHrId();
    }

}
