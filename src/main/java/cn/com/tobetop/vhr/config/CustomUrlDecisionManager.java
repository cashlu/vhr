package cn.com.tobetop.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @program: vhr
 * @description: 判断当前用户是否具备相应的角色。
 * @author: Cash
 * @create: 2021-10-17 22:42
 **/
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    /**
     * 判断当前登录用户，是否具备要求的角色。
     *
     * @param authentication   当前登录用户
     * @param object           前端发来的请求对象
     * @param configAttributes 需要具备的角色集合
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication,
                       Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        /*
        判断流程：
        1、遍历需要的角色列表，如果有“ROLE_LOGIN”，则判断用户是否已登录，如果登录，则允许，否则阻止。
        2、比对需要的角色列表和当前用户具备的角色列表，如果有相同项，则代表用户具备角色，允许访问。
        3、前两步都没有匹配项，则阻止访问。
         */


        // 遍历请求需要的角色列表
        for (ConfigAttribute attribute : configAttributes) {
            String needRole = attribute.getAttribute();
            // 如果角色是ROLE_LOGIN，根据约定，该角色名称代表，只要是登录用户就可访问。
            if ("ROLE_LOGIN".equals(needRole)) {
                // 如果是匿名用户，也就是没有登录，那么拒绝访问。
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录！");
                } else {
                    return;
                }
            }
            // 遍历当前登录用户的角色
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                // 如果当前用户的某个角色和需要的某个角色相等，则代表具备权限。
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        // 全部遍历后，抛出异常，阻止访问。
        throw new AccessDeniedException("权限不足，请联系管理员！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        // 默认值是false，需要改成true
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // 默认值是false，需要改成true
        return true;
    }
}
