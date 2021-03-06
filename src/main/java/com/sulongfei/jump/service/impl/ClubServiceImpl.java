package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.constants.Constants;
import com.sulongfei.jump.constants.ResponseStatus;
import com.sulongfei.jump.dto.ClubDTO;
import com.sulongfei.jump.mapper.ClubMapper;
import com.sulongfei.jump.mapper.IntegralMapper;
import com.sulongfei.jump.model.Club;
import com.sulongfei.jump.model.Integral;
import com.sulongfei.jump.response.ClubRes;
import com.sulongfei.jump.response.IntegralRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.UserRes;
import com.sulongfei.jump.rest.response.OrgResponse;
import com.sulongfei.jump.rest.response.RestResponse;
import com.sulongfei.jump.service.ClubService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 16:18
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
@CacheConfig(cacheNames = {Constants.CacheName.SERVICE_CACHE + Constants.CacheName.CLUB_CACHE})
public class ClubServiceImpl implements ClubService {
    @Autowired
    private RestService restService;
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private IntegralMapper integralMapper;

    @Override
    @Cacheable(keyGenerator = "cacheKeyGenerator")
    public Response localClubList(ClubDTO clubDTO) {
        PageHelper.startPage(clubDTO.getPage(), clubDTO.getPageSize());
        List<Club> list = clubMapper.queryList();
        List<ClubRes> data = Lists.newArrayList();
        list.forEach(club -> {
            ClubRes clubRes = new ClubRes();
            BeanUtils.copyProperties(club, clubRes);
            data.add(clubRes);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }

    @Override
    @Cacheable(keyGenerator = "cacheKeyGenerator")
    public Response localClubAll() {
        List<Club> list = clubMapper.selectAll();
        List<ClubRes> data = Lists.newArrayList();
        list.forEach(club -> {
            ClubRes clubRes = new ClubRes();
            BeanUtils.copyProperties(club, clubRes);
            data.add(clubRes);
        });
        return Response.toResponse(data, data.size());
    }

    @Override
    @Transactional(readOnly = false)
    @CacheEvict(allEntries = true)
    public Response synchronizeClubList() {
        ResponseEntity<RestResponse<List<OrgResponse>>> res = restService.getOrgList(null);
        if (!HttpStatus.OK.equals(res.getStatusCode()) || !"200".equals(res.getBody().getErrorCode())) {
            return new Response(ResponseStatus.SYNCHR_FAILURE);
        }
        for (OrgResponse org : res.getBody().getResult()) {
            Club club = clubMapper.selectByOrgId(org.getOrgId());
            if (club != null) {
                // 更新
                if (compare(org, club)) {
                    continue;
                }
                toClub(org, club);
                clubMapper.updateByPrimaryKey(club);
            } else {
                club = new Club();
                toClub(org, club);
                clubMapper.insertSelective(club);
            }
        }
        return new Response();
    }

    @Override
    public Response rankList(ClubDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<Integral> integrals = integralMapper.rankListTop(dto.getRemoteClubId());
        List<IntegralRes> data = Lists.newArrayList();
        integrals.forEach(integral -> {
            IntegralRes integralRes = new IntegralRes();
            UserRes userRes = new UserRes();
            BeanUtils.copyProperties(integral.getUser(), userRes);
            integralRes.setIntegral(integral.getIntegral());
            integralRes.setUser(userRes);
            data.add(integralRes);
        });
        return Response.toResponse(data, new PageInfo<>(integrals).getTotal());
    }

    private Club toClub(OrgResponse org, Club club) {
        club.setRemoteClubId(org.getOrgId());
        club.setSupplierId(org.getSupplierId());
        club.setSupplierName(org.getSupplierName());
        club.setSupplierAddress(org.getSupplierAddress());
        club.setCompanyName(org.getCompanyName());
        club.setPhone(org.getPhone());
        club.setIsOrg(org.getIsOrg());
        club.setStatus(org.getStatus());
        club.setCreateTime(org.getCreate_time());
        club.setLastUpdateTime(org.getLastUpdateTime());
        return club;
    }

    private Boolean compare(OrgResponse org, Club club) {
        if (!ObjectUtils.isEmpty(org.getOrgId()) && org.getOrgId().equals(club.getRemoteClubId()) &&
                !ObjectUtils.isEmpty(org.getSupplierId()) && org.getSupplierId().equals(club.getSupplierId()) &&
                !ObjectUtils.isEmpty(org.getSupplierName()) && org.getSupplierName().equals(club.getSupplierName()) &&
                !ObjectUtils.isEmpty(org.getSupplierAddress()) && org.getSupplierAddress().equals(club.getSupplierAddress()) &&
                !ObjectUtils.isEmpty(org.getCompanyName()) && org.getCompanyName().equals(club.getCompanyName()) &&
                !ObjectUtils.isEmpty(org.getPhone()) && org.getPhone().equals(club.getPhone()) &&
                !ObjectUtils.isEmpty(org.getIsOrg()) && org.getIsOrg().equals(club.getIsOrg()) &&
                !ObjectUtils.isEmpty(org.getStatus()) && org.getStatus().equals(club.getStatus()) &&
                !ObjectUtils.isEmpty(org.getCreate_time()) && org.getCreate_time().equals(club.getCreateTime()) &&
                !ObjectUtils.isEmpty(org.getLastUpdateTime()) && org.getLastUpdateTime().equals(club.getLastUpdateTime())
        ) {
            return true;
        } else {
            return false;
        }
    }
}
