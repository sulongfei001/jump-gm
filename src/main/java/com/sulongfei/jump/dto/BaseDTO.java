package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = -2303123669547996281L;
    /**
     * 服务主键Id
     */
    private Long id;
    /**
     * 分页数大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer page;
}
