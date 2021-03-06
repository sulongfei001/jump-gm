package com.sulongfei.jump.response;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sulongfei.jump.model.Menu;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/23 16:44
 * @Version 1.0
 */
@Data
public class SysUserRes {
    private String sysName;

    private String sysCode;

    private String avatar;

    private List<Menu> routers = Lists.newArrayList();

    private Set<String> permissions = Sets.newHashSet();
}
