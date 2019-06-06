package com.sulongfei.jump.rest.request;

import lombok.Data;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/5 11:37
 * @Version 1.0
 */
@Data
public class OrgRequest {
    private Long gameId;
    private Long orgId;

    public OrgRequest(Long gameId, Long orgId) {
        this.gameId = gameId;
        this.orgId = orgId;
    }
}
