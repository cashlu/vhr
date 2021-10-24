package cn.com.tobetop.vhr.config;

import cn.com.tobetop.vhr.entity.Menu;
import cn.com.tobetop.vhr.entity.Role;
import cn.com.tobetop.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @program: vhr
 * @description: 根据前端传来的请求地址，分析出需要的角色。
 * @author: Cash
 * @create: 2021-10-17 02:57
 **/
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 根据前端发送的请求url，查询数据库，获取该请求允许的角色列表。
     * @param o
     * @return 本次请求需要的角色
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取请求的地址（参数o是一个FilterInvocation对象）
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 获取所有菜单数据，每一条数据都有该菜单项对应的角色。
        List<Menu> menus = menuService.getAllMenusWithRole();
        /*
        使用AntPathMatcher.match()方法做路径的匹配（数据库中存储的url，是ant风格的路径字符串），如果匹配成功，则获取
        角色的name属性。
        本方法要求的返回值是Collection<ConfigAttribute>，而menu.getRoles()返回的是List<Role>，所以需要先将List<Role>
        对象转换为字符串数组，然后使用Spring Security的SecurityConfig.createList()方法，将字符串数组转换为Collection<ConfigAttribute>。
        如果在做路径匹配时，没有匹配到相应的url，那么则按照业务约定，返回"ROLE_login"。
         */
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        // 没有匹配上的url，登录后都可访问。
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
