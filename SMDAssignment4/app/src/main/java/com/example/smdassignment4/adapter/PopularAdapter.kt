package com.example.smdassignment4.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smdassignment4.R
import com.example.smdassignment4.model.Category
import com.example.smdassignment4.model.Popular
import java.lang.String
import kotlin.Int


class PopularAdapter(private val context: Context, private val Populars: List<Popular>, private val mColumnLayout: Int) : RecyclerView.Adapter<PopularAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mColumnLayout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.title.text = Populars[position].title;
        holder.fees.text = (String.valueOf(Populars[position].fees))

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            Populars[position].pic,
            "drawable",
            holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.pic)

    }

    override fun getItemCount(): Int {
        return Populars.size
    }

    class UserViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val fees:TextView = itemView.findViewById(R.id.fees)
        val pic:ImageView= itemView.findViewById(R.id.pic)
        val addBtn:TextView = itemView.findViewById(R.id.addBtn)
    }
}