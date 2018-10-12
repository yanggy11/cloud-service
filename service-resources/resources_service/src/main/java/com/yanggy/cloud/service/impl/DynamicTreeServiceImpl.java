package com.yanggy.cloud.service.impl;

import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.entity.DynamicTree;
import com.yang.cloud.mapper.DynamicTreeMapper;
import com.yanggy.cloud.service.IDynamicTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/18 11:50
 * @Description:
 */

@Service("dynamicService")
public class DynamicTreeServiceImpl implements IDynamicTreeService {

    @Autowired
    private DynamicTreeMapper dynamicTreeMapper;
    @Override
    public ResponseEntity<?> getAllTrees() {
        List<DynamicTree>  dynamicTrees= dynamicTreeMapper.getAllTrees();
        Map<Long, List<DynamicTree>> map = dynamicTrees.stream().filter(dynamicTree -> dynamicTree.getParentId() != 1).collect(Collectors.groupingBy(DynamicTree::getParentId, Collectors.toList()));

        return new ResponseEntity<>(map);
    }
}
