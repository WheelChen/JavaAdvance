package com.example.multidb.auto.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.multidb.auto.entity.OdBase;
import com.example.multidb.auto.dao.OdBaseMapper;
import com.example.multidb.auto.service.OdBaseService;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:17
 */
@Service
public class OdBaseServiceImpl implements OdBaseService {

    @Resource
    private OdBaseMapper odBaseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return odBaseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OdBase record) {
        return odBaseMapper.insert(record);
    }

    @Override
    public int insertSelective(OdBase record) {
        return odBaseMapper.insertSelective(record);
    }

    @Override
    public OdBase selectByPrimaryKey(Integer id) {
        return odBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OdBase record) {
        return odBaseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OdBase record) {
        return odBaseMapper.updateByPrimaryKey(record);
    }

}

