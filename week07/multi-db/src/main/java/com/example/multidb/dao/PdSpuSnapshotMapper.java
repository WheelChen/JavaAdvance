package com.example.multidb.dao;

import com.example.multidb.entity.PdSpuSnapshot;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */
public interface PdSpuSnapshotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PdSpuSnapshot record);

    int insertSelective(PdSpuSnapshot record);

    PdSpuSnapshot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdSpuSnapshot record);

    int updateByPrimaryKey(PdSpuSnapshot record);
}