package com.example.fragment.AdapterClass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment.Model.dyanamiclistModel
import com.example.fragment.R

class CustomAdapter(private val mList: List<dyanamiclistModel>,val callbacks: (Position:Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardviewdesign, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dyanamiclist = mList[position]
        holder.itemView.findViewById<TextView>(R.id.cardviewidtext).text =
            dyanamiclist.displytext
        holder.itemView.setOnClickListener{

            callbacks.invoke(position)
        }
    }
    override fun getItemCount(): Int {
        return mList.size
    }
}
class ViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
}




