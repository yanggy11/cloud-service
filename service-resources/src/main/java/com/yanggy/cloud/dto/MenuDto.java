package com.yanggy.cloud.dto;

import com.yanggy.cloud.entity.Menu;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/23 13:53
 * @Description:
 */

@Data
public class MenuDto implements Serializable {
    
	private static final long serialVersionUID = 6178268884464796499L;
	private Long menuId;
    private String menu;
    private String menuName;
    private String icon;
    private String parentMenu;
    private List<Menu> childrens = new ArrayList<>();
}
