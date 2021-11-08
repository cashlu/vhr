package cn.com.tobetop.vhr.controller.system;

import cn.com.tobetop.vhr.model.Hr;
import cn.com.tobetop.vhr.model.RespBean;
import cn.com.tobetop.vhr.model.Role;
import cn.com.tobetop.vhr.model.vo.HrRoleVo;
import cn.com.tobetop.vhr.service.HrService;
import cn.com.tobetop.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 操作员管理的Controller
 * @author: Cash
 * @create: 2021-11-01 02:58
 **/
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;


    @GetMapping("/exceptMe/")
    public RespBean getAllHrExceptMe(String keyword) {
        List<Hr> hrs = hrService.getAllHrExceptMe(keyword);
        return RespBean.ok(null, hrs);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新用户成功！");
        }
        return RespBean.error("更新用户失败！");
    }

    @GetMapping("/roles/")
    public RespBean getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return RespBean.ok(null, roles);
    }

    @PutMapping("/role/")
    public RespBean updateHrRole(@RequestBody HrRoleVo hrRoleVo) {
        Integer hrId = hrRoleVo.getHrId();
        List<Integer> roleIds = hrRoleVo.getRoleIds();

        if (hrService.updateRole(hrId, roleIds)) {
            return RespBean.ok("更新角色组成功！");
        }
        return RespBean.error("更新角色组失败！");
    }

    @DeleteMapping("/{hrId}")
    public RespBean deleteHrById(@PathVariable Integer hrId){
        if(hrService.deleteHrById(hrId)){
            return RespBean.ok("删除用户成功！");
        }
        return RespBean.error("删除用户失败");
    }

}
