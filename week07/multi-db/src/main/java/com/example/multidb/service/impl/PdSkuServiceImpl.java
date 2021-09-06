package com.example.multidb.service.impl;

import com.example.multidb.dao.PdSkuMapper;
import com.example.multidb.entity.PdSku;
import com.example.multidb.service.PdSkuService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:17
 */
@Service
public class PdSkuServiceImpl implements PdSkuService {

    @Resource
    private PdSkuMapper pdSkuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pdSkuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PdSku record) {
        return pdSkuMapper.insert(record);
    }

    @Override
    public int insertSelective(PdSku record) {
        return pdSkuMapper.insertSelective(record);
    }

    @Override
    public PdSku selectByPrimaryKey(Integer id) {
        return pdSkuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PdSku record) {
        return pdSkuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PdSku record) {
        return pdSkuMapper.updateByPrimaryKey(record);
    }

}

