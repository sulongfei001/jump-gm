package com.sulongfei.jump.web.interceptor;

import com.sulongfei.jump.constants.ResponseStatus;
import com.sulongfei.jump.exception.JumpException;
import com.sulongfei.jump.mapper.SysUserMapper;
import com.sulongfei.jump.model.SysUser;
import com.sulongfei.jump.utils.PrincipalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description
 * @Author sulongfei
 * @Date 2018/12/24 11:46
 * @Version 1.0
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
@Slf4j
public class UserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private SysUserMapper userMapper;

    private static ThreadLocal<SysUser> localUser = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 解决跨域
        crossDomain(response);
        log.info("requestURL = {}，access_token = {}", request.getRequestURL().toString(), request.getParameter("access_token"));
        SysUser sysUser = userMapper.selectSysUserByUsername((PrincipalUtils.getPrincipal().getName()));
        if (sysUser == null) {
            throw new JumpException(ResponseStatus.Code.FAILURE, ResponseStatus.NO_PERMISSION);
        }
        localUser.set(sysUser);

        return true;
    }

    public static SysUser getLocalUser() {
        return localUser.get();
    }

    private void crossDomain(HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,PATCH,DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,Authorization");
    }
}
