package com.example.gads2020.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gads2020.Dao.LearningLeaders
import com.example.gads2020.R

class RecyclerAdapter(val leaders: List<LearningLeaders>) :
    RecyclerView.Adapter<RecyclerAdapter.LeadersViewHolder>() {
    var leadersList: List<LearningLeaders> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadersViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_learners, parent, false)
        return LeadersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return leadersList.size
    }

    override fun onBindViewHolder(holder: LeadersViewHolder, position: Int) {
        holder.name.text = "Name: " + leadersList.get(position).name
        holder.score.text =
            leadersList.get(position).hours.toString() + " learning hours, " + leadersList.get(
                position
            ).country
        Glide.with(holder.image).load(leadersList.get(position).badgeUrl)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setLeadersListItems(leadersList: List<LearningLeaders>) {
        this.leadersList = leadersList;
        notifyDataSetChanged()
    }

    class LeadersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTextView)
        val score: TextView = itemView.findViewById(R.id.scoreTextView)
        val image: ImageView = itemView.findViewById(R.id.badge)
    }
}