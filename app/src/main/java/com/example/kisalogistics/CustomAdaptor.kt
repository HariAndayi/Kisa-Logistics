package com.example.kisalogistics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.database.FirebaseDatabase

class CustomAdapter(var context: Context, var data:ArrayList<Truck>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtTruckNumber:TextView
        var mTxtLoadSize:TextView
        var mTxtTruckPrice:TextView
        var imgTruckPic:ImageView
        var btnDelete:Button
        var btnUpdate:Button
        init {
            this.mTxtTruckNumber = row?.findViewById(R.id.mtvtrucknumber) as TextView
            this.mTxtLoadSize = row?.findViewById(R.id.mtvloadsize) as TextView
            this.mTxtTruckPrice = row?.findViewById(R.id.mtvtruckprice) as TextView
            this.imgTruckPic = row?.findViewById(R.id.mimgtruckpic) as ImageView
            this.btnDelete = row?.findViewById(R.id.mbtndelete) as Button
            this.btnUpdate = row?.findViewById(R.id.mbtnupdate) as Button
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.truck_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Truck = getItem(position) as Truck
        viewHolder.mTxtTruckNumber.text = item.truckNumber
        viewHolder.mTxtLoadSize.text = item.loadSize
        viewHolder.mTxtTruckPrice.text = item.truckPrice
        Glide.with(context).load(item.truckImage).into(viewHolder.imgTruckPic)
        viewHolder.btnDelete.setOnClickListener {
            var delRef = FirebaseDatabase.getInstance().getReference().child("Houses/"+item.truckId)
            delRef.removeValue()
        }
        viewHolder.btnUpdate.setOnClickListener {

        }
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}
