package com.example.multidb.auto.service;

import com.example.multidb.auto.entity.PdSku;
    

/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface PdSkuService{


    int deleteByPrimaryKey(Integer id);

    int insert(PdSku record);

    int insertSelective(PdSku record);

    PdSku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdSku record);

    int updateByPrimaryKey(PdSku record);

}
