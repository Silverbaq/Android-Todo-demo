package dk.w4.tododemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dk.w4.tododemo.entity.Todo

class TodoAdapter(
    private val items: MutableList<Todo> = mutableListOf(),
    private val clickListener: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size

    fun update(items: List<Todo>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class TodoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Todo) {
            view.findViewById<CheckBox>(R.id.checkBox).isChecked = item.done

            view.findViewById<TextView>(R.id.descriptionText).text = item.description

            view.findViewById<CheckBox>(R.id.checkBox).setOnClickListener {
                clickListener(item)
            }
        }
    }
}