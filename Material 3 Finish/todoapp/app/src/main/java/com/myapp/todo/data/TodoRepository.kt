package com.myapp.todo.data

import androidx.lifecycle.LiveData
import com.myapp.todo.data.TodoDao
import com.myapp.todo.model.Todo

class TodoRepository(private val todoDao: TodoDao) {

    val allTodoItems: LiveData<List<Todo>> = todoDao.getAllTodoItems();

    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    suspend fun delete(todo: Todo) {
        todoDao.delete(todo)
    }

    suspend fun update(todo: Todo) {
        todoDao.update(todo)
    }

    fun getTodoByStatus(isCompleted: Boolean) : LiveData<List<Todo>> {
        return todoDao.getTodoItems(isCompleted)
    }
}