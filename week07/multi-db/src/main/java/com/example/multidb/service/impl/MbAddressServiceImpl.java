package com.example.multidb.service.impl;

import com.example.multidb.dao.MbAddressMapper;
import com.example.multidb.entity.MbAddress;
import com.example.multidb.service.MbAddressService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:16
 */
@Service
public class MbAddressServiceImpl implements MbAddressService {

    @Resource
    private MbAddressMapper mbAddressMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mbAddressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MbAddress record) {
        return mbAddressMapper.insert(record);
    }

    @Override
    public int insertSelective(MbAddress record) {
        return mbAddressMapper.insertSelective(record);
    }

    @Override
    public MbAddress selectByPrimaryKey(Integer id) {
        return mbAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MbAddress record) {
        return mbAddressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MbAddress record) {
        return mbAddressMapper.updateByPrimaryKey(record);
    }

}

