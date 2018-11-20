package com.yanggy.cloud.common.service.impl;

import com.yanggy.cloud.common.config.enums.ErrorCode;
import com.yanggy.cloud.common.dto.TodoItemsDto;
import com.yanggy.cloud.common.entity.TodoItems;
import com.yanggy.cloud.common.mapper.TodoItemsMapper;
import com.yanggy.cloud.common.service.ITodoItemsService;
import com.yanggy.cloud.common.utils.ResponseEntityBuilder;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:33
 */

@Service
public class TodoItemsServiceImpl implements ITodoItemsService {
    private static Logger logger = LoggerFactory.getLogger(TodoItemsServiceImpl.class);
    @Autowired
    private TodoItemsMapper todoItemsMapper;

    @Override
    public ResponseEntityDto<?> addTodoItems(TodoItems todoItems) {
        ResponseEntityDto<?> res;

        try {
            todoItemsMapper.addTodoItems(todoItems);
            res = ResponseEntityBuilder.buildNormalResponseEntity();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("新增代办事项发生错误:{}", e);
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }

    @Override
    public ResponseEntityDto<?> getTodosByPage(TodoItemsDto todoItemsDto) {
        ResponseEntityDto<?> res;

        try{
            res = ResponseEntityBuilder.buildNormalResponseEntity(todoItemsMapper.getTodos(todoItemsDto));
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("查询代办事项发生错误:{}", e);
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }

    @Override
    public ResponseEntityDto<?> deleteItems(TodoItemsDto todoItemsDto) {
        ResponseEntityDto<?> res;

        try {
            todoItemsMapper.deleteItems(todoItemsDto);
            res = ResponseEntityBuilder.buildNormalResponseEntity();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("查询代办事项发生错误:{}", e);
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }

    @Override
    public ResponseEntityDto<?> finishItems(TodoItemsDto todoItemsDto) {
        ResponseEntityDto<?> res;

        try {
            todoItemsMapper.finishItems(todoItemsDto);
            res = ResponseEntityBuilder.buildNormalResponseEntity();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("查询代办事项发生错误:{}", e);
            res = ResponseEntityBuilder.buildErrorResponseEntity(ErrorCode.UNKONWN_ERROR);
        }
        return res;
    }
}
