package todo.addTodo.service;

import todo.addTodo.dto.AddTodoDto;

public interface AddTodoService {
	int insertTodo(AddTodoDto dto);
}
