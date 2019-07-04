package com.sulongfei.jump.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:19
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ClubDTO extends BaseDTO {

    private static final long serialVersionUID = 6970777365267346974L;

    private Long remoteClubId;
}
