package com.yanggy.cloud.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author derrick.yang
 * @Date 10/17/18 11:54
 */

@Data
public class Page implements Serializable{
    private int page = 1;
    private int pageSize = 20;
    private int total;
    private int offset;

    public void setOffset(int offset) {
        this.offset = (this.page - 1) * this.pageSize;
    }
}
