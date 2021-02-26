package dk.w4.tododemo

import com.nhaarman.mockitokotlin2.mock
import dk.w4.tododemo.entity.Todo
import dk.w4.tododemo.repository.TodoMemoryRepository
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class TodoViewModelTest {
    //@get:Rule
    //val rule = InstantTaskExecutorRule()

    private val repository: TodoMemoryRepository = mock()

    private val todoViewModel = TodoViewModel(repository)

    @Test
    fun somehiting() {
        val item: Todo = Todo(id = "1", description = "noget tekst", done = false)
        todoViewModel.addTodoItem(item)

        verify(repository.add(item), times(1))
    }
}