package com.yanggy.cloud.common.mapper;

import com.yanggy.cloud.common.dto.TodoItemsDto;
import com.yanggy.cloud.common.entity.TodoItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:36
 */

@Mapper
@Component
public interface TodoItemsMapper {
    int addTodoItems(TodoItems todoItems);

    List<TodoItems> getTodos(TodoItemsDto todoItemsDto);

    int deleteItems(TodoItemsDto todoItemsDto);

    int finishItems(TodoItemsDto todoItemsDto);
}
