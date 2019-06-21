package com.sulongfei.jump.response;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:22
 * @Version 1.0
 */
@Data
public class ClubRes {

    private Long id;

    private Long remoteClubId;

    private Long supplierId;

    private String supplierName;

    private String supplierAddress;

    private String companyName;

    private String phone;

    private Byte isOrg;

    private Byte status;

    private Timestamp createTime;

    private Timestamp lastUpdateTime;

}
