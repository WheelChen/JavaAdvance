package com.example.multidb.auto.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.multidb.auto.dao.PdSpuMapper;
import com.example.multidb.auto.entity.PdSpu;
import com.example.multidb.auto.service.PdSpuService;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:55:16
 */
@Service
public class PdSpuServiceImpl implements PdSpuService {

    @Resource
    private PdSpuMapper pdSpuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pdSpuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PdSpu record) {
        return pdSpuMapper.insert(record);
    }

    @Override
    public int insertSelective(PdSpu record) {
        return pdSpuMapper.insertSelective(record);
    }

    @Override
    public PdSpu selectByPrimaryKey(Integer id) {
        return pdSpuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PdSpu record) {
        return pdSpuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PdSpu record) {
        return pdSpuMapper.updateByPrimaryKey(record);
    }

}

