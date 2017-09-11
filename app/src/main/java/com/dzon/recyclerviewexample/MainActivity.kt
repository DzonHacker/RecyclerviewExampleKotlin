package com.dzon.recyclerviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //setting up adapter with recyclerview

    var adapter:CostomRecyclerAdapter?=null
    var dataModel:ArrayList<Model> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name_list = arrayOf("Jacob","Ethan","James","John","William","Daniel","Matthew","Lucas","David","Jackson")
        var age_list = arrayOf(20,23,12,39,54,39,26,34,44,40)

        for(i in 0..name_list.size-1){
            dataModel.add(Model(name_list[i],age_list[i]))
        }
        adapter = CostomRecyclerAdapter(dataModel,applicationContext)
        var layout_manager = LinearLayoutManager(applicationContext)
        recycler_view.layoutManager = layout_manager
        recycler_view.adapter = adapter

    }
}
