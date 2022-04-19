package com.myapp.todo.feature.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.myapp.todo.data.TodoDatabase
import com.myapp.todo.data.TodoRepository
import com.myapp.todo.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
    private val shouldShowCompletedTasks: Boolean,
    private val shouldShowUncompletedTasks: Boolean
) : AndroidViewModel(application) {
    private val repository: TodoRepository

    val todoItems: LiveData<List<Todo>>
    init {
        val dao = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(dao)
        todoItems = when {
            shouldShowCompletedTasks -> {
                repository.getTodoByStatus(true)
            }
            shouldShowUncompletedTasks -> {
                repository.getTodoByStatus(false)
            }
            else -> {
                repository.allTodoItems
            }
        }
    }

    fun delete(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(todo)
    }

    fun update(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(todo)
    }
}