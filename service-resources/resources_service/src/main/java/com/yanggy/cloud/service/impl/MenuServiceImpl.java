package com.yanggy.cloud.service.impl;

import com.yang.cloud.dto.MenuDto;
import com.yang.cloud.dto.Page;
import com.yang.cloud.dto.ResponseEntity;
import com.yang.cloud.entity.Menu;
import com.yang.cloud.mapper.MenuMapper;
import com.yang.cloud.param.MenuParam;
import com.yanggy.cloud.service.IMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 17:02
 * @Description:
 */

@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public ResponseEntity<?> getAllMenus(MenuParam menuParam) {
        List<Menu> menus = menuMapper.getAllMenusByParent(0l);
        List<MenuDto> menuDtos = menus.stream().map(menu -> {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            menuDto.setMenuId(menu.getId());
            List<Menu> childrens = menuMapper.getAllMenusByParent(menu.getId());
            if(null == childrens ||childrens.size() <= 0) {
                childrens = null;
            }
            menuDto.setChildrens(childrens);
            return menuDto;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(menuDtos);
    }

    @Override
    public ResponseEntity<?> getMenusList(MenuParam menuParam) {
        Page page = new Page();


        int count = menuMapper.countMenus(menuParam);
        int totalPage = count % menuParam.getPageSize() == 0 ? count / menuParam.getPageSize() : count / menuParam.getPageSize() + 1;

        page.setTotalRecord(count);
        page.setTotalPage(totalPage);
        page.setPage(menuParam.getPage());
        page.setPageSize(menuParam.getPageSize());

        int offset = (menuParam.getPage() - 1) * menuParam.getPageSize();
        menuParam.setOffset(offset);
        List<Menu> menus = menuMapper.getAllMenus(menuParam);
        List<MenuDto> menuDtos = menus.stream().map(menu -> {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            menuDto.setMenuId(menu.getId());
            if(-1 ==menu.getParentId()) {
                menuDto.setParentMenu("--");
            }else {
                Menu parentMenu = menuMapper.getMenuById(menu.getParentId());
                if (null == parentMenu) {
                    menuDto.setParentMenu("--");
                } else {
                    menuDto.setParentMenu(parentMenu.getMenuName());
                }
            }
            return menuDto;
        }).collect(Collectors.toList());

        page.setData(menuDtos);

        return new ResponseEntity<>(page);
    }
}
