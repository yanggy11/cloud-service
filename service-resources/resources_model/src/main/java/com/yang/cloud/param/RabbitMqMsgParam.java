package com.yang.cloud.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/8/18 15:18
 */

@Data
public class RabbitMqMsgParam implements Serializable {
    private Long id;
    private int isProcessed;
    private int type;

    private List<Long> ids;

    private int page;
    private int pageSize;
    private int offset;
}
