package com.yang.cloud.mapper;

import com.yang.cloud.entity.DynamicTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by yangguiyun on 2017/10/18.
 */

@Mapper
public interface DynamicTreeMapper {
    List<DynamicTree> getAllTrees();
    List<DynamicTree> getAllTreesByParentId(@Param("parentId") Long parentId);
}
