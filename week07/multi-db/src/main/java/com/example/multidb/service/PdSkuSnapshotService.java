package com.example.multidb.service;

import com.example.multidb.entity.PdSkuSnapshot;


/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface PdSkuSnapshotService{


    int deleteByPrimaryKey(Integer id);

    int insert(PdSkuSnapshot record);

    int insertSelective(PdSkuSnapshot record);

    PdSkuSnapshot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdSkuSnapshot record);

    int updateByPrimaryKey(PdSkuSnapshot record);

}
