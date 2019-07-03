package com.sulongfei.jump.response;

import lombok.Data;

import java.util.Date;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/30 11:49
 * @Version 1.0
 */
@Data
public class UserRes {
    private Long id;

    private Long memberId;

    private Boolean isSaler;

    private String phoneNumber;

    private String password;

    private String avatar;

    private String nickname;

    private Byte gender;

    private Date createTime;

    private Date updateTime;

    private Long registerClue;

    private Boolean deleteStatus;

    private Date lastOperationTime;

    private Long lastOperationClub;

    private String receiverName;

    private String province;

    private String city;

    private String district;

    private String receiverAddress;

    private Boolean everydayTicket;

    private Integer ticketNum;

}
