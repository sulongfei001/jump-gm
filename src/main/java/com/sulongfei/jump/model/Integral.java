package com.sulongfei.jump.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Integral extends Model {

    private Long id;

    private Long userId;

    private Long remoteClubId;

    private Integer integral;

    private SecurityUser user;
}