package com.example.multidb.dao;

import com.example.multidb.entity.OdBase;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface OdBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OdBase record);

    int insertSelective(OdBase record);

    OdBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OdBase record);

    int updateByPrimaryKey(OdBase record);
}