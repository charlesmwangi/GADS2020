package com.example.gads2020.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gads2020.R
import com.example.gads2020.Dao.Result

class LeadersAdapter  (val leaders: List<Result>): RecyclerView.Adapter<LeadersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_learners, parent, false)
        return LeadersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return leaders.size
    }

    override fun onBindViewHolder(holder: LeadersViewHolder, position: Int) {
        return holder.bind(leaders[position])
    }
}

class LeadersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo: ImageView = itemView.findViewById(R.id.gadsImageView)
    private val name: TextView = itemView.findViewById(R.id.nameTextView)
    private val hours:TextView = itemView.findViewById(R.id.scoreTextView)

    fun bind(leaders: Result) {
        Glide.with(itemView.context).load(leaders.badgeUrl).into(photo)
        name.text = "Name: "+leaders.name
        hours.text = leaders.hours.toString() + "learning hours, "+ leaders.country
    }

}