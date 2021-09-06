package com.example.multidb.dao;

import com.example.multidb.entity.PdSpu;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:40
 */
public interface PdSpuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PdSpu record);

    int insertSelective(PdSpu record);

    PdSpu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdSpu record);

    int updateByPrimaryKey(PdSpu record);
}