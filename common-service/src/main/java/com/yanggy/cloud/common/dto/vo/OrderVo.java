package com.yanggy.cloud.common.dto.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author derrick.yang
 * @Date 25/10/2018 09:08
 */

@Data
public class OrderVo implements Serializable {
    private Long id;
    private Long userId;
    private String name;
    private String phone;
    private String email;
    private Date orderTime;
}
