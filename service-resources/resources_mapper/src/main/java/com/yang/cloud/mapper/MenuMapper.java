package com.yang.cloud.mapper;

import com.yang.cloud.entity.Menu;
import com.yang.cloud.param.MenuParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangguiyun on 2017/10/21.
 */

@Mapper
public interface MenuMapper {

    List<Menu> getAllMenus(MenuParam menu);
    List<Menu> getAllMenusByParent(@Param("parentId") Long parentId);
    Menu getMenuById(@Param("id") Long id);

    int countMenus(MenuParam menu);
}
