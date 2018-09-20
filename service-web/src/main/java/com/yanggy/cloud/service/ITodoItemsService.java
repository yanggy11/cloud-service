package com.yanggy.cloud.service;

import com.yanggy.cloud.dto.TodoItemsDto;
import com.yanggy.cloud.entity.TodoItems;
import com.yanggy.cloud.utils.ResponseEntityDto;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:33
 */
public interface ITodoItemsService {
    ResponseEntityDto<?> addTodoItems(TodoItems todoItems);

    ResponseEntityDto<?> getTodosByPage(TodoItemsDto todoItemsDto);
}
