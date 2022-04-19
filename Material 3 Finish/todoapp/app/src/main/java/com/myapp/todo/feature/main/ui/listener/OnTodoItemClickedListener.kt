package com.myapp.todo.feature.main.ui.listener

import com.myapp.todo.model.Todo

interface OnTodoItemClickedListener {
    fun onTodoItemCompleted(item: Todo)
    fun onTodoItemRemoved(item: Todo)
}