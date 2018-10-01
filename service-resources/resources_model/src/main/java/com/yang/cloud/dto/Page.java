package com.yang.cloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangguiyun
 * @Date: 2017/10/17 16:21
 * @Description:
 */

@Data
public class Page<T> implements Serializable {
    
	private static final long serialVersionUID = -5494010619280385426L;
	private int page;
    private int pageSize;
    private int totalRecord;
    private int totalPage;

    T data;

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}
