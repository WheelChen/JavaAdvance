package com.example.multidb.service.impl;

import com.example.multidb.entity.PdSpuSnapshot;
import com.example.multidb.service.PdSpuSnapshotService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.example.multidb.dao.PdSpuSnapshotMapper;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:17
 */
@Service
public class PdSpuSnapshotServiceImpl implements PdSpuSnapshotService {

    @Resource
    private PdSpuSnapshotMapper pdSpuSnapshotMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pdSpuSnapshotMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PdSpuSnapshot record) {
        return pdSpuSnapshotMapper.insert(record);
    }

    @Override
    public int insertSelective(PdSpuSnapshot record) {
        return pdSpuSnapshotMapper.insertSelective(record);
    }

    @Override
    public PdSpuSnapshot selectByPrimaryKey(Integer id) {
        return pdSpuSnapshotMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PdSpuSnapshot record) {
        return pdSpuSnapshotMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PdSpuSnapshot record) {
        return pdSpuSnapshotMapper.updateByPrimaryKey(record);
    }

}

