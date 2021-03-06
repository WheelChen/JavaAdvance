package com.example.multidb.auto.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.multidb.auto.dao.PdSkuSnapshotMapper;
import com.example.multidb.auto.entity.PdSkuSnapshot;
import com.example.multidb.auto.service.PdSkuSnapshotService;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:17
 */
@Service
public class PdSkuSnapshotServiceImpl implements PdSkuSnapshotService {

    @Resource
    private PdSkuSnapshotMapper pdSkuSnapshotMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pdSkuSnapshotMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PdSkuSnapshot record) {
        return pdSkuSnapshotMapper.insert(record);
    }

    @Override
    public int insertSelective(PdSkuSnapshot record) {
        return pdSkuSnapshotMapper.insertSelective(record);
    }

    @Override
    public PdSkuSnapshot selectByPrimaryKey(Integer id) {
        return pdSkuSnapshotMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PdSkuSnapshot record) {
        return pdSkuSnapshotMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PdSkuSnapshot record) {
        return pdSkuSnapshotMapper.updateByPrimaryKey(record);
    }

}

