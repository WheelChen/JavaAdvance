package com.example.multidb.auto.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.multidb.auto.dao.OdProductMapper;
import com.example.multidb.auto.entity.OdProduct;
import com.example.multidb.auto.service.OdProductService;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:17
 */
@Service
public class OdProductServiceImpl implements OdProductService {

    @Resource
    private OdProductMapper odProductMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return odProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OdProduct record) {
        return odProductMapper.insert(record);
    }

    @Override
    public int insertSelective(OdProduct record) {
        return odProductMapper.insertSelective(record);
    }

    @Override
    public OdProduct selectByPrimaryKey(Integer id) {
        return odProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OdProduct record) {
        return odProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OdProduct record) {
        return odProductMapper.updateByPrimaryKey(record);
    }

}

