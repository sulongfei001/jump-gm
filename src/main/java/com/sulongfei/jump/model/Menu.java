package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class Menu extends Model {

    private static final long serialVersionUID = -643219688245770663L;

    private Long id;

    private Long parentId;

    private Integer sequence;

    private Integer menuType;

    private String name;

    private String text;

    private String path;

    private String component;

    private String redirect;

    private String icon;

    private String permission;

    private String permissionName;

    private Boolean hidden;

    private List<Menu> children = new ArrayList<>();

    private Meta meta;

    @Data
    public static class Meta implements Serializable {

        private static final long serialVersionUID = -3075193428932941702L;

        private String title;

        private String icon;

        private boolean noCache;

        private Set<String> permission;

        public Meta(String title, String icon, boolean noCache, Set<String> permission) {
            this.title = title;
            this.icon = icon;
            this.noCache = noCache;
            this.permission = permission;
        }


    }


}