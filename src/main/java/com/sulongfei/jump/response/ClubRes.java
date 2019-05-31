package com.sulongfei.jump.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:22
 * @Version 1.0
 */
@Data
public class ClubRes implements Serializable {

    private static final long serialVersionUID = 7363552638274078748L;

    private Long id;

    private Long remoteClubId;

    private String clubName;

    public ClubRes(Long id, Long remoteClubId, String clubName) {
        this.id = id;
        this.remoteClubId = remoteClubId;
        this.clubName = clubName;
    }
}
