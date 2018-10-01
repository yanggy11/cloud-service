package com.yang.cloud.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/3/18 14:36
 */

@Data
public class ResourcesDto implements Serializable {
    
	private static final long serialVersionUID = 8237038977789826822L;
	private Long id;
    private String resource;
    private String resourceName;

    private List<com.yang.cloud.dto.ResourcesDto> children;
    private Long parentId;
    private boolean isEdit = false;
}
