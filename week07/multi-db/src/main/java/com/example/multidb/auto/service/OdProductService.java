package com.example.multidb.auto.service;

import com.example.multidb.auto.entity.OdProduct;
    

/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface OdProductService{


    int deleteByPrimaryKey(Integer id);

    int insert(OdProduct record);

    int insertSelective(OdProduct record);

    OdProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OdProduct record);

    int updateByPrimaryKey(OdProduct record);

}
