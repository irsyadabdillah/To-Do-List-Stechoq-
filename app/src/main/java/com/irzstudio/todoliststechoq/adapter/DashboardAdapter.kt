package com.irzstudio.todoliststechoq.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irzstudio.todoliststechoq.R
import com.irzstudio.todoliststechoq.listener.OnClickListener
import com.irzstudio.todoliststechoq.model.ToDosResponse
import kotlinx.android.synthetic.main.item_task.view.*

class DashboardAdapter(val onClick : (toDosResponse: ToDosResponse, v: View) -> Unit): RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    private val list: MutableList<ToDosResponse> = mutableListOf()

    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (todosRespone: ToDosResponse) {

            itemView.setOnClickListener {
                onClick.invoke(todosRespone, it)
            }

            itemView.txt_title.text = todosRespone.title

            if (todosRespone.status == true) {
                itemView.txt_status.text = "Completed"
            }else{
                itemView.txt_status.text = ""
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DashboardAdapter.DashboardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardAdapter.DashboardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataAdapter(data: List<ToDosResponse>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}