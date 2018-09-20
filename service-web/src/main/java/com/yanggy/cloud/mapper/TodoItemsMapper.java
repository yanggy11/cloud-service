package com.yanggy.cloud.mapper;

import com.yanggy.cloud.dto.TodoItemsDto;
import com.yanggy.cloud.entity.TodoItems;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:36
 */

@Mapper
public interface TodoItemsMapper {
    int addTodoItems(TodoItems todoItems);

    List<TodoItems> getTodos(TodoItemsDto todoItemsDto);
}
