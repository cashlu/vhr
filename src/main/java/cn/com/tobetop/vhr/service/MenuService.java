package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Hr;
import cn.com.tobetop.vhr.entity.Menu;
import cn.com.tobetop.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

    public List<Menu> getMenuByHrId() {
        // 从内存中获取当前登录用户的ID
        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    // TODO: 这个方法在每次前端发送请求时，都会调用，应该使用缓存！
    //@Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
