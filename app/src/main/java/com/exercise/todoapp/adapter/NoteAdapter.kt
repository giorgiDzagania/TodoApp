package com.exercise.todoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exercise.todoapp.Data.Note
import com.exercise.todoapp.R
import com.exercise.todoapp.databinding.AddNoteBinding
import com.exercise.todoapp.databinding.CheakboxItemBinding

class NoteAdapter(val notes: ArrayList<Note>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AddNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = notes[position]
        holder.someFunction(model)

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class ViewHolder(val binding: AddNoteBinding): RecyclerView.ViewHolder(binding.root) {
        val itemTitle: TextView = binding.textTitle
        val linerLayout: LinearLayout = binding.linearLayout

        fun someFunction(model: Note){
            itemTitle.text = model.title
            linerLayout.removeAllViews()
            val context = binding.root.context

            for (item in model.content){
                val cheakBoxItemBinding = CheakboxItemBinding.inflate(LayoutInflater.from(context),linerLayout,true)
                cheakBoxItemBinding.textContent.text = item
            }

        }



    }

}


//binding.linearProjects.removeAllViews()
//val context = itemView.context
//item.content?.forEach { workload ->
//    val projectItemBinding = ProjectItemBinding.inflate(inflater, container, true)
//    with(projectItemBinding) {
//        tvProjectName.text = workload.projectName
//        tvProjectFTE.text = context.getString(R.string.workload, workload.workloadValue)
//        tvBillable.text = workload.type?.shortName(context)
//        val colorRes = workload.type?.colorRes()!!
//        tvBillable.setTextColor(context.getColor(colorRes))
//        ivBillableDot.setImageResource(colorRes)
//    }
//}
//private val inflater = itemView.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater