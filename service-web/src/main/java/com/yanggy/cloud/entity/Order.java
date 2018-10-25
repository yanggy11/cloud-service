package com.yanggy.cloud.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derrick.yang
 * @Date 10/16/18 09:40
 */

@Data
public class Order implements Serializable {
    private Long id;
    private Long userId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}