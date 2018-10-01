package com.yang.cloud.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/18 11:02
 * @Description:
 */
@Data
public class DynamicTreeDto implements Serializable {
    
	private static final long serialVersionUID = 8996883759931714650L;
	private Long id;
    private String name;
    private List<DynamicTreeBaseDto> childrens;
}
