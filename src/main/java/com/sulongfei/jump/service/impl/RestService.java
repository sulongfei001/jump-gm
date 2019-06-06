package com.sulongfei.jump.service.impl;

import com.alibaba.fastjson.JSON;
import com.sulongfei.jump.rest.request.GoodsRequest;
import com.sulongfei.jump.rest.request.OrgRequest;
import com.sulongfei.jump.rest.response.GoodsResponse;
import com.sulongfei.jump.rest.response.OrgResponse;
import com.sulongfei.jump.rest.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/30 15:38
 * @Version 1.0
 */
@Service
public class RestService {
    @Autowired
    private RestTemplate restTemplate;

    private static final Long gameId = 1L;

    private static final String realmName = "http://dt.9hou.me/crmmarketdev";

    private static HttpHeaders headers = new HttpHeaders();

    static {
        MimeType mimeType = MimeTypeUtils.parseMimeType("application/json");
        MediaType mediaType = new MediaType(mimeType.getType(), mimeType.getSubtype(), Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
    }


    public ResponseEntity<RestResponse<List<OrgResponse>>> getOrgList(Long orgId) {
        String url = realmName + "/gamePlat/getOrgList";
        OrgRequest request = new OrgRequest(gameId, orgId);
        ResponseEntity<RestResponse<List<OrgResponse>>> result = restTemplate.exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(JSON.toJSONString(request), headers),
                new ParameterizedTypeReference<RestResponse<List<OrgResponse>>>() {
                });
        return result;
    }

    public ResponseEntity<RestResponse<List<GoodsResponse>>> getGoodsList(List<Long> goodsId) {
        String url = realmName + "/gamePlat/getGoodsList";
        GoodsRequest request = new GoodsRequest(gameId, goodsId);
        ResponseEntity<RestResponse<List<GoodsResponse>>> result = restTemplate.exchange(url,
                HttpMethod.POST,
                new HttpEntity<>(JSON.toJSONString(request), headers),
                new ParameterizedTypeReference<RestResponse<List<GoodsResponse>>>() {
                });
        return result;
    }
}
