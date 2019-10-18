package com.info.billgenrator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_shopping_list.view.*

class ShoppingListAdapter(var shoppingList: ArrayList<ShoppingListModel>, var context: Context) :

    RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_shopping_list, null)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoppingListModel=shoppingList[position]
        holder.itemView.txtShoppingListName.text=shoppingListModel.shoppingListName
        holder.itemView.txtCount.text=shoppingListModel.itemCount.toString()
        holder.itemView.setOnClickListener {
            context.startActivity(ItemsListActivity.getIntent(context,shoppingListModel))
        }

        holder.itemView.imgOptions.setOnClickListener {
            showPopup(it,shoppingList[position],context)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    fun showPopup(v: View, shoppingListModel: ShoppingListModel, mContext: Context) {
        val popup = PopupMenu(mContext, v)
        popup.inflate(R.menu.options_menu)
  //      var actionRename = popup.menu.getItem(1)

        popup.setOnMenuItemClickListener {
                item ->true
        }

        popup.show()
    }

}