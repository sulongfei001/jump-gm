package com.sulongfei.jump.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sulongfei.jump.mapper.MenuMapper;
import com.sulongfei.jump.model.Menu;
import com.sulongfei.jump.model.SysUser;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.SysUserRes;
import com.sulongfei.jump.service.SysUserService;
import com.sulongfei.jump.utils.PrincipalUtils;
import com.sulongfei.jump.web.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/23 16:41
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Response<SysUserRes> sysUserInfo() {
        Response<SysUserRes> response = new Response<>();

        SysUser sysUser = UserInterceptor.getLocalUser();

        // 登陆用户所有角色
        Collection<? extends GrantedAuthority> authorities = PrincipalUtils.getPrincipal().getAuthorities();
        Set<String> permissions = Sets.newHashSet();
        authorities.forEach(auth -> permissions.add(auth.getAuthority()));

        // 所有访问菜单的路由
        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUser.getId());
        // 父级菜单
        List<Menu> topMenu = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream().filter(menu -> null == menu.getParentId()).collect(Collectors.toList());
        // 这种写法是查出所有的菜单，移除顶级菜单，剩余的菜单就不是顶级菜单也就是parentId 都是不为null
        Optional.ofNullable(menus).orElse(Collections.emptyList()).removeAll(topMenu);
        // 整合成父子结构
        List<Menu> routers = recursivePermission(Lists.newArrayList(), topMenu, menus, permissions);

        SysUserRes sysUserResponse = new SysUserRes();
        sysUserResponse.setSysCode(sysUser.getUsername());
        sysUserResponse.setSysName(sysUser.getSysName());
        sysUserResponse.setAvatar(sysUser.getAvatar());
        sysUserResponse.setRouters(routers);
        sysUserResponse.setPermissions(permissions);

        response.setData(sysUserResponse);

        return response;
    }

    /**
     * 获取访问菜单
     *
     * @param result      菜单
     * @param menus       菜单
     * @param permissions 权限
     */
    private List<Menu> recursivePermission(List<Menu> result, List<Menu> menus, List<Menu> menuList, Set<String> permissions) {

        menus.forEach(k -> {
            Menu.Meta meta = new Menu.Meta(k.getName(), k.getIcon(), k.getHidden(), permissions);
            k.setMeta(meta);
            // 顶级菜单的 component 元素值设置为Layout
            if (null == k.getParentId()) {
                k.setComponent("Layout");
            }
            // 筛选出此用户所拥有的菜单的子菜单
            List<Menu> child = menuList.stream().filter(s -> k.getId().compareTo(s.getParentId()) == 0 && 1 == k.getMenuType() && 1 == s.getMenuType()).collect(Collectors.toList());
            List<Menu> list = recursivePermission(Lists.newArrayList(), child, menuList, permissions);
            k.setChildren(list);
            result.add(k);
        });
        return result;
    }
}
