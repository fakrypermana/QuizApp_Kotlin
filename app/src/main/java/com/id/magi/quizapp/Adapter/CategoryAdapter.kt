package com.id.magi.quizapp.Adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.id.magi.quizapp.Model.Category
import com.id.magi.quizapp.Interface.IOnRecyclerViewItemClickListener
import com.id.magi.quizapp.R

class CategoryAdapter(internal var context: Context,
                      internal var categoryList: List<Category>):
RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_category,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_category_name.text = categoryList[position].name
        holder.setOnRecyclerViewItemClickListener(object : IOnRecyclerViewItemClickListener {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context,"Click on"+categoryList[position].name,Toast.LENGTH_SHORT).show()
            }
        })
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var tv_category_name : TextView
        internal var cv_category : CardView
        internal lateinit var iOnRecyclerViewItemClickListener:IOnRecyclerViewItemClickListener

        fun setOnRecyclerViewItemClickListener(iOnRecyclerViewItemClickListener: IOnRecyclerViewItemClickListener){

            this.iOnRecyclerViewItemClickListener = iOnRecyclerViewItemClickListener
        }

        init {
            tv_category_name = itemView.findViewById(R.id.tv_category_name) as TextView
            cv_category = itemView.findViewById(R.id.cv_category) as CardView

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            iOnRecyclerViewItemClickListener.onClick(view,adapterPosition)
        }


    }
}