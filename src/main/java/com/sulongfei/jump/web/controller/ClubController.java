package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.ClubDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @PostMapping("/local/list")
    public Response localClubList(@RequestBody ClubDTO dto) {
        return clubService.localClubList(dto);
    }

    @PostMapping("/local/all")
    public Response localClubAll() {
        return clubService.localClubAll();
    }

    @PostMapping("/rankList")
    public Response rankList(@RequestBody ClubDTO dto) {
        return clubService.rankList(dto);
    }

    @PostMapping("/synchronize")
    public Response synchronizeClubList() {
        return clubService.synchronizeClubList();
    }
}
