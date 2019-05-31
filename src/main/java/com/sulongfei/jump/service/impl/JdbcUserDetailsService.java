package com.sulongfei.jump.service.impl;

import com.sulongfei.jump.mapper.MenuMapper;
import com.sulongfei.jump.mapper.SysUserMapper;
import com.sulongfei.jump.model.Menu;
import com.sulongfei.jump.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class JdbcUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        SysUser sysUser = sysUserMapper.selectSysUserByUsername(userName);
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUser.getId());
        Set<String> permissions = Optional.of(menus).orElse(Collections.emptyList()).stream().filter(menu -> !StringUtils.isEmpty(menu.getPermission())).map(Menu::getPermission).collect(Collectors.toSet());
        permissions.forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission)));
        return new User(userName, sysUser.getPassword(), grantedAuthorities);
    }


}
