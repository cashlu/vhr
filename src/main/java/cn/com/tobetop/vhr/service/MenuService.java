package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Hr;
import cn.com.tobetop.vhr.entity.Menu;
import cn.com.tobetop.vhr.mapper.MenuMapper;
import cn.com.tobetop.vhr.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: vhr
 * @description:
 * @author: Cash
 * @create: 2021-10-13 00:57
 **/

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenuByHrId() {
        // 从内存中获取当前登录用户的ID
        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    // TODO: 这个方法在每次前端发送请求时，都会调用，应该使用缓存！
    //@Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    /**
     * 通过roleId，获取该Role具备的Menu的ID列表。
     *
     * @param rid 角色ID
     * @return 权限（菜单）ID
     */
    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    /**
     * 更新Role和Menu的关系表。参数接收角色的ID和权限的ID集合。
     * 首先将该数据库中该角色所有的权限删除，然后再根据权限ID重新插入。
     *
     * @param rid  角色ID
     * @param mids 权限ID的集合
     * @return 更新是否成功。
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMenuRole(Integer rid, List<Integer> mids) {
        // rid不能为空
        if (rid == null) {
            throw new IllegalArgumentException("rid不能为空！");
        }
        Integer delCount = menuRoleMapper.deleteByRid(rid);
        // 如果mids为空，说明不需要插入任何数据，如果签名的删除语句没有异常，直接返回true即可。
        if (mids.size() == 0) {
            return true;
        }
        // 如果有插入数据，判断一下插入的数据，和mids的长度是否一致。
        Integer insertCount = menuRoleMapper.batchInsert(rid, mids);
        return insertCount.equals(mids.size());
    }
}
