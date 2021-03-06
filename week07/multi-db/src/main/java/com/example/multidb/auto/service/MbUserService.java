package com.example.multidb.auto.service;

import com.example.multidb.auto.entity.MbUser;
    

/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface MbUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(MbUser record);

    int insertSelective(MbUser record);

    MbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MbUser record);

    int updateByPrimaryKey(MbUser record);

}
