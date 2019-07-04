package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.ClubDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/28 14:40
 * @Version 1.0
 */
public interface ClubService {
    Response localClubList(ClubDTO clubDTO);

    Response localClubAll();

    Response synchronizeClubList();

    Response rankList(ClubDTO dto);
}
