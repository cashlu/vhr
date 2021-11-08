package cn.com.tobetop.vhr.controller.system.basic;

import cn.com.tobetop.vhr.model.Menu;
import cn.com.tobetop.vhr.model.RespBean;
import cn.com.tobetop.vhr.model.Role;
import cn.com.tobetop.vhr.service.MenuService;
import cn.com.tobetop.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 角色及权限相关的Controller。
 * @author: Cash
 * @create: 2021-10-29 20:41
 **/

@RestController
@RequestMapping("/system/basic/permission/")
public class PermissionController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;


    @GetMapping("/")
    public RespBean getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok(null, roles);
    }

    @GetMapping("/menus")
    public RespBean getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return RespBean.ok(null, menus);
    }

    @GetMapping("/mids/{rid}")
    public RespBean getMidsByRid(@PathVariable Integer rid) {
        List<Integer> mids = menuService.getMidsByRid(rid);
        return RespBean.ok(null, mids);
    }

    @PutMapping("/{rid}")
    public RespBean updateMenuRole(@PathVariable Integer rid, @RequestBody List<Integer> mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("权限更新成功！");
        }
        return RespBean.error("权限更新失败！");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role)==1) {
            return RespBean.ok("创建角色成功！");
        }
        return RespBean.error("创建角色失败！");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除角色成功！");
        }
        return RespBean.error("删除角色失败！");
    }


}
