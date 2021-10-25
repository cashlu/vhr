package cn.com.tobetop.vhr.service;

import cn.com.tobetop.vhr.entity.Hr;
import cn.com.tobetop.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: vhr
 * @description: Hr的Service类。实现了UserDetailsService接口。
 * @author: Cash
 * @create: 2021-09-21 01:51
 **/
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    /**
     * 因为实现了UserDetailsService接口，所以必须实现该接口的loadUserByUsername()方法。该方法的作用是通过username字符串，
     * 查找并返回该用户的UserDetails对象。简单来说，就是通过username查找数据库的hr表，找不到抛出 UsernameNotFoundException
     * 异常；找到的话，创建Hr对象，并且从数据库中查找出该Hr对象的Roles集合，set给该对象，然后返回。因为Hr实现了UserDetails接口，
     * 所以直接返回Hr对象即可。
     *
     * @param username 需要查找的用户名
     * @return 查找出的Hr对象
     * @throws UsernameNotFoundException 用户名不存在的异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 如果登录成功，给用户设置角色
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }
}
