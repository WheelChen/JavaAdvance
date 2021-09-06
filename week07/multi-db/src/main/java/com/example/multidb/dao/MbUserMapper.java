package com.example.multidb.dao;

import com.example.multidb.entity.MbUser;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface MbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MbUser record);

    int insertSelective(MbUser record);

    MbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MbUser record);

    int updateByPrimaryKey(MbUser record);
}