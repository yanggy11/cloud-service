package com.yanggy.cloud.common.service;

import com.yanggy.cloud.common.dto.TodoItemsDto;
import com.yanggy.cloud.common.entity.TodoItems;
import com.yanggy.cloud.common.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:33
 */
public interface ITodoItemsService {
    ResponseEntityDto<?> addTodoItems(TodoItems todoItems);

    ResponseEntityDto<?> getTodosByPage(TodoItemsDto todoItemsDto);

    ResponseEntityDto<?> deleteItems(TodoItemsDto todoItemsDto);

    ResponseEntityDto<?> finishItems(TodoItemsDto todoItemsDto);
}
