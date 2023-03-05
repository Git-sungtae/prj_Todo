package dao;

import java.util.List;

import dto.TodoDto;

public class TodoDao {
	int todos;
	
	private int addTodo(TodoDto toDoDto) {
		int addedTodos = 0;
		this.todos += addedTodos;
		return this.todos;
	}
	
	private List<TodoDto> getTodos() {
		return List<TodoDto> todoList;
	}
	
	private int updateTodo(TodoDto toDoDto) {
		int updatedTodos = 0;
		return Math.abs(this.todos - updatedTodos);
	}

}
