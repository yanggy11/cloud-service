package com.yanggy.cloud.common.api;

import com.yanggy.cloud.common.dto.TodoItemsDto;
import com.yanggy.cloud.common.entity.TodoItems;
import com.yanggy.cloud.common.service.ITodoItemsService;
import com.yanggy.cloud.common.utils.ResponseEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author derrick.yang
 * @Date 9/20/18 22:31
 */

@RestController
@RequestMapping(value = "/todos/**")
public class TodoController {

    @Autowired
    private ITodoItemsService iTodoItemsService;

    @PostMapping(value = "addTodos")
    public ResponseEntityDto<?> addTodos(@RequestBody TodoItems todo) {

        return iTodoItemsService.addTodoItems(todo);
    }

    @PostMapping(value = "getTodos")
    public ResponseEntityDto<?> getTodos(@RequestBody TodoItemsDto todoItemsDto) {
        return iTodoItemsService.getTodosByPage(todoItemsDto);
    }
    @PostMapping(value = "delete")
    public ResponseEntityDto<?> deleteItems(@RequestBody TodoItemsDto todoItemsDto) {
        return iTodoItemsService.deleteItems(todoItemsDto);
    }
    @PostMapping(value = "finish")
    public ResponseEntityDto<?> finishItems(@RequestBody TodoItemsDto todoItemsDto) {
        return iTodoItemsService.finishItems(todoItemsDto);
    }
}
