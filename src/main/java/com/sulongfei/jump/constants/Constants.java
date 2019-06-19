package com.sulongfei.jump.constants;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/29 17:09
 * @Version 1.0
 */
public interface Constants {

    interface Delete {
        Boolean NO = false;
        Boolean YES = true;
    }

    interface CacheName {
        String SERVICE_CACHE = "service_cache:";
        String CLUB_CACHE = "club_cache:";
        String GOODS_CACHE = "goods_cache:";
        String SIMPLE_ROOM_CACHE = "simple_room_cache:";
        String SPREAD_ROOM_CACHE = "spread_room_cache:";
    }

    /**
     * 常用字符串数字常量
     */
    interface Common {
        String ZERO = "0";
        String ONE = "1";
        String TWO = "2";
        String THREE = "3";
        String FOUR = "4";
        String FIVE = "5";
        String SIX = "6";
        String SEVEN = "7";
        String EIGHT = "8";
        String NINE = "9";
    }
}
