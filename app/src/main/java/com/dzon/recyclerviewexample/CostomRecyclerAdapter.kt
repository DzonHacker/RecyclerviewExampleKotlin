package com.dzon.recyclerviewexample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by msi on 9/11/2017.
 */
class CostomRecyclerAdapter(dataModel:ArrayList<Model>,context: Context):RecyclerView.Adapter<CostomRecyclerAdapter.CostomViewHolder>() {

    //alt+enter
    var dataModel:ArrayList<Model> = dataModel
    var mContext = context


    override fun onBindViewHolder(holder: CostomViewHolder?, position: Int) {
        var item = dataModel[position]
        var name = item.mName
        var age = item.mAge
        holder!!.nameTv.text = "Name: "+name
        holder.ageTv.text = "Age: "+age

        holder.setOnCostomItemClickListener(object :CostomItemClickListener{
            override fun onCostomItemClickListener(view: View, pos: Int) {
                Toast.makeText(mContext,"Name: "+name,Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CostomViewHolder {
        //inflate item row
       var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_row,parent,false)
        return CostomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    class CostomViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        var nameTv:TextView
        var ageTv:TextView
        var costomItemClickListener:CostomItemClickListener?=null
        init {
            nameTv = itemView.findViewById(R.id.name_tv)
            ageTv = itemView.findViewById(R.id.age_tv)
            itemView.setOnClickListener(this)
        }

        fun setOnCostomItemClickListener(itemClickListener:CostomItemClickListener){
            this.costomItemClickListener = itemClickListener
        }

        override fun onClick(p0: View?) {
            this.costomItemClickListener!!.onCostomItemClickListener(p0!!,adapterPosition)
        }


    }
}

//Alternately you can also write CostomViewHolder like











