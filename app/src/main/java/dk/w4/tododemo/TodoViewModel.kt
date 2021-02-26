package dk.w4.tododemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.w4.tododemo.entity.Todo
import dk.w4.tododemo.repository.TodoMemoryRepository

class TodoViewModel(private val todoRepository: TodoMemoryRepository) : ViewModel() {
    private val _todoItems = MutableLiveData<List<Todo>>()
    val todoItem: LiveData<List<Todo>> = _todoItems

    fun updateItem(item: Todo) {
        todoRepository.edit(item)
    }

    fun addTodoItem(item: Todo) {
        todoRepository.add(item)
        val myList = todoRepository.fetchAll()
        _todoItems.postValue(myList)
    }
}