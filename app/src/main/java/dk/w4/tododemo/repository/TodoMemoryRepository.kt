package dk.w4.tododemo.repository

import dk.w4.tododemo.entity.Todo

open class TodoMemoryRepository : TodoRepository {
    private val todos: MutableList<Todo> = mutableListOf()
    var idCounter = 0

    override fun add(item: Todo) {
        item.id = idCounter.toString()
        idCounter++
        todos.add(item)
    }

    override fun remove(item: Todo) {
        todos.remove(item)
    }

    override fun edit(item: Todo) {
        val index = todos.indexOfFirst { it == item }
        todos[index] = item
    }

    override fun fetchAll(): List<Todo> {
        return todos
    }

    override fun fetch(id: String): Todo {
        return todos.first { it.id == id }
    }
}