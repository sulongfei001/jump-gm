package com.sulongfei.jump.rest.response;

import lombok.Data;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/5 11:28
 * @Version 1.0
 */
@Data
public class RestResponse<T> {
    private String errorCode;
    private String errMsg;
    private T result;
}
