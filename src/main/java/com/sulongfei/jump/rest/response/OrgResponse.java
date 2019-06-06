package com.sulongfei.jump.rest.response;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/5 11:26
 * @Version 1.0
 */
@Data
public class OrgResponse {

    private Long supplierId;

    private String supplierName;

    private String supplierAddress;

    private String companyName;

    private String phone;

    private Long orgId;

    private Byte isOrg;

    private Byte status;

    private Timestamp create_time;

    private Timestamp lastUpdateTime;

}
