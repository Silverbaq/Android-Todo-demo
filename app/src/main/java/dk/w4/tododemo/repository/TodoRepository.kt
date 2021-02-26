package dk.w4.tododemo.repository

import dk.w4.tododemo.entity.Todo

interface TodoRepository {
    fun add(item: Todo)
    fun remove(item: Todo)
    fun edit(item: Todo)
    fun fetchAll() : List<Todo>
    fun fetch(id: String): Todo
}