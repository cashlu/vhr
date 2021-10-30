package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Role;
import cn.com.tobetop.vhr.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: vhr
 * @Description: 角色的Service。
 * @Author: Cash
 * @Create: 2021-10-29 20:44
 **/

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        String rolePrefix = "ROLE_";

        // Spring Security中，role必须以“ROLE_”前缀开始，所以为了方便，在数据入库的时候，自动加上。
        if (!role.getName().startsWith(rolePrefix)) {
            role.setName(rolePrefix + role.getName());
        }
        return roleMapper.insert(role);

    }

    public Integer deleteRoleById(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
