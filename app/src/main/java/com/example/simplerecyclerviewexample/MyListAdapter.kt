package com.example.simplerecyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simplerecyclerviewexample.databinding.ListItemBinding

class MyListAdapter(private val listOfItem: List<ListItem>, private val onClick: (ListItem) -> Unit):
    RecyclerView.Adapter<MyListAdapter.ListViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
   class ListViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        //old school variant
        val item = listOfItem[position]
        holder.binding.textItem.text = item.text
        holder.itemView.setOnClickListener {
            onClick(item)
            Toast.makeText(holder.itemView.context, item.text,
                Toast.LENGTH_SHORT).show()
        }

        // more concise and new variant
//        with(holder){
//            with(listOfItem.get(position)){
//               binding.textItem.text = text
//
//                holder.itemView.setOnClickListener {
//                    onClick(this)
//                    Toast.makeText(holder.itemView.context, text,
//                        Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    override fun getItemCount(): Int = listOfItem.size

}