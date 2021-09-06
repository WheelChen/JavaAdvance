package com.example.multidb.service;

import com.example.multidb.entity.OdBase;


/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface OdBaseService{


    int deleteByPrimaryKey(Integer id);

    int insert(OdBase record);

    int insertSelective(OdBase record);

    OdBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OdBase record);

    int updateByPrimaryKey(OdBase record);

}
