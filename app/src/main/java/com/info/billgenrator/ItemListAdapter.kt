package com.info.billgenrator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_shopping_list.view.*
import kotlinx.android.synthetic.main.item_shopping_list.view.imgOptions

class ItemListAdapter (var itemList: ArrayList<Item>, var context: Context) :

    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item, null)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item=itemList[position]
        holder.itemView.txtItemName.text=item.itemName.toUpperCase()

        when {
            item.isAdded -> holder.itemView.imgOptions.setImageResource(R.drawable.ic_added)
            item.isSelected -> holder.itemView.imgOptions.setImageResource(R.drawable.ic_check)
            else -> holder.itemView.imgOptions.setImageResource(R.drawable.ic_uncheck)
        }

        holder.itemView.setOnClickListener {
            itemList[position].isSelected = !itemList[position].isSelected
            (context as OnItemSelectListner).onItemSelect( itemList[position])
           notifyDataSetChanged()
        }
    }
    
    fun getSelectedItem():ArrayList<Item>{
        var selectedItems= itemList.filter { it.isSelected &&!it.isAdded }
        return java.util.ArrayList(selectedItems)
    }

    fun unSelectAll(){
        var selectedItems=getSelectedItem()
        selectedItems.iterator().forEach { it.isSelected=false }
        notifyDataSetChanged()
    }

    fun itemsAdded(){
        var selectedItems=getSelectedItem()
        selectedItems.iterator().forEach { it.isAdded=true }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}