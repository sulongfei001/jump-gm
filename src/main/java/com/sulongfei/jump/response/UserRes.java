package com.sulongfei.jump.response;

import lombok.Data;

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

    private Boolean isSaler;

    private String phoneNumber;

    private String avatar;

    private String nickname;

    private Byte gender;

    private String receiverName;

    private String receiverAddress;

    private Boolean everydayTicket;

    private Integer ticketNum;
}
