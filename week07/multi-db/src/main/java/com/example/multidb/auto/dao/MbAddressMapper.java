package com.example.multidb.auto.dao;

import com.example.multidb.auto.entity.MbAddress;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:40
 */
public interface MbAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MbAddress record);

    int insertSelective(MbAddress record);

    MbAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MbAddress record);

    int updateByPrimaryKey(MbAddress record);
}