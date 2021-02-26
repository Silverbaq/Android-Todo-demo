package dk.w4.tododemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dk.w4.tododemo.entity.Todo
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val todoViewModel: TodoViewModel by viewModel()

    private val myAdapter = TodoAdapter(
        clickListener = ::onDoneClicked
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoViewModel.todoItem.observe(this, { todoList ->
            myAdapter.update(todoList)
        })

        addButton.setOnClickListener {
            val description = task.text.toString()
            val todo = Todo("0", description)
            todoViewModel.addTodoItem(todo)
        }

        todoList.adapter = myAdapter
    }

    private fun onDoneClicked(item: Todo) {
        todoViewModel.updateItem(item)
        Toast.makeText(this, "function invoked", Toast.LENGTH_SHORT).show()
    }
}