package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Club extends Model {

    private static final long serialVersionUID = 997627662628618997L;

    private Long id;

    private Long remoteClubId;

    private String clubName;


}