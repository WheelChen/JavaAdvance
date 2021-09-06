package com.example.multidb.dao;

import com.example.multidb.entity.PdSku;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface PdSkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PdSku record);

    int insertSelective(PdSku record);

    PdSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdSku record);

    int updateByPrimaryKey(PdSku record);
}