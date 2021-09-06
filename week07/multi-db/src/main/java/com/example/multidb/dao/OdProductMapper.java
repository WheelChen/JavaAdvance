package com.example.multidb.dao;

import com.example.multidb.entity.OdProduct;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface OdProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OdProduct record);

    int insertSelective(OdProduct record);

    OdProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OdProduct record);

    int updateByPrimaryKey(OdProduct record);
}