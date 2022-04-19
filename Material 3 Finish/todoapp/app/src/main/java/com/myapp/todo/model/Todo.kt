package com.myapp.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.myapp.todo.converters.Converter
import org.joda.time.LocalDate

@Entity(tableName = "todo_table")
data class Todo(
    val title: String,
    val description: String,
    @TypeConverters(Converter::class)
    val dueDate: LocalDate,
    var isCompleted: Boolean = false
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0

}