package com.example.multidb.auto.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.multidb.auto.dao.MbUserMapper;
import com.example.multidb.auto.entity.MbUser;
import com.example.multidb.auto.service.MbUserService;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:17
 */
@Service
public class MbUserServiceImpl implements MbUserService {

    @Resource
    private MbUserMapper mbUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mbUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MbUser record) {
        return mbUserMapper.insert(record);
    }

    @Override
    public int insertSelective(MbUser record) {
        return mbUserMapper.insertSelective(record);
    }

    @Override
    public MbUser selectByPrimaryKey(Integer id) {
        return mbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MbUser record) {
        return mbUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MbUser record) {
        return mbUserMapper.updateByPrimaryKey(record);
    }

}

