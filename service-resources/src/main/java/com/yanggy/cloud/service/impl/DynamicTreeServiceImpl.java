package com.yanggy.cloud.service.impl;

import com.yanggy.cloud.dto.ResponseEntity;
import com.yanggy.cloud.entity.DynamicTree;
import com.yanggy.cloud.mapper.DynamicTreeMapper;
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
        List<DynamicTree> dynamicTrees = new ArrayList<>();
        dynamicTrees = dynamicTreeMapper.getAllTrees();
        List<DynamicTree> parentNodes = dynamicTrees.stream().filter(dynamicTree -> dynamicTree.getParentId() == 1).collect(Collectors.toList());
        Map<Long, List<DynamicTree>> map = dynamicTrees.stream().filter(dynamicTree -> dynamicTree.getParentId() != 1).collect(Collectors.groupingBy(DynamicTree::getParentId, Collectors.toList()));

        return new ResponseEntity<>(map);
    }
}
