package com.example.smdassignment4.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smdassignment4.R
import com.example.smdassignment4.model.Category


class CategoryAdapter(private val context: Context, private val Categories: List<Category>, private val mColumnLayout: Int) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mColumnLayout, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryName.text = Categories[position].title
        when (position) {
            0 -> {
                holder.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_bg1)
            }
            1 -> {
                holder.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_bg2)
            }
            2 -> {
                holder.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_bg3)
            }
            3 -> {
                holder.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_bg4)
            }
            4 -> {
                holder.mainLayout.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.cat_bg5)
            }
        }
        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            Categories[position].pic,
            "drawable",
            holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.categoryPic)
    }

    override fun getItemCount(): Int {
        return Categories.size
    }

    class CategoryViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView = itemView.findViewById(R.id.catName)
        val categoryPic:ImageView = itemView.findViewById(R.id.catPic)
        val mainLayout:ConstraintLayout = itemView.findViewById(R.id.mainLayout)
    }
}