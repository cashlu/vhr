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
 * @description:
 * @author: Cash
 * @create: 2021-09-21 01:51
 **/
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

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
