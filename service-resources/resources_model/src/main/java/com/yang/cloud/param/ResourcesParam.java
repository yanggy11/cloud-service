package com.yang.cloud.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/21 10:54
 * @Description:
 */

@Data
public class ResourcesParam implements Serializable {
    private Long resourceId;
    private String resourceName;
    private int page = 1;
    private int pageSize = 15;
    private List<Long> resourceIds;
    private Long parentId;
}
