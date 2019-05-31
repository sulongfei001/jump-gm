package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.impl.CommonEnumService;
import com.sulongfei.jump.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/23 16:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/system")
public class SystemController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private CommonEnumService commonEnumService;

    @PostMapping("/sysUserInfo")
    public Response sysUserInfo() {
        return sysUserService.sysUserInfo();
    }

    @PostMapping("/enumInfo")
    public Response commonEnumInfo() {
        return commonEnumService.getCommonEnumInfo();
    }
}
