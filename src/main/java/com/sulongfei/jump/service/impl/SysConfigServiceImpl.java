package com.sulongfei.jump.service.impl;

import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.SysConfigDTO;
import com.sulongfei.jump.mapper.GlobalDictionaryMapper;
import com.sulongfei.jump.model.GlobalDictionary;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.SysConfigRes;
import com.sulongfei.jump.service.SysConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/19 10:31
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private GlobalDictionaryMapper dictionaryMapper;

    @Override
    public Response sysConfig() {
        List<GlobalDictionary> list = dictionaryMapper.selectAll();
        List<SysConfigRes> data = Lists.newArrayList();
        list.stream().forEach(globalDictionary -> {
            SysConfigRes res = new SysConfigRes();
            BeanUtils.copyProperties(globalDictionary, res);
            data.add(res);
        });
        return new Response(data);
    }

    @Override
    @Transactional(readOnly = false)
    public Response updateSysConfig(SysConfigDTO dto) {
        dictionaryMapper.updateByKey(dto.getKey(), dto.getValue());
        return new Response();
    }
}
