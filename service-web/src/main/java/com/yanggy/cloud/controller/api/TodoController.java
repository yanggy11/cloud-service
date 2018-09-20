package com.yanggy.cloud.controller.api;

import com.yanggy.cloud.dto.TodoItemsDto;
import com.yanggy.cloud.entity.TodoItems;
import com.yanggy.cloud.service.ITodoItemsService;
import com.yanggy.cloud.utils.ResponseEntityDto;
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
}
