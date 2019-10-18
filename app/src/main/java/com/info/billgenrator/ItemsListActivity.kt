package com.info.billgenrator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_items_list.*
import kotlinx.android.synthetic.main.content_item.*

class ItemsListActivity : AppCompatActivity(), OnItemSelectListner {


    private lateinit var shoppingListModel: ShoppingListModel
    private lateinit var adapter: ItemListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_list)

        shoppingListModel = intent.getSerializableExtra("item") as ShoppingListModel
        supportActionBar?.let {
            it.title = shoppingListModel.shoppingListName
        }

        var list = ArrayList<Item>()
        var unitList = ArrayList<ItemUnit>()
        unitList.add(ItemUnit(1, "Kg"))
        unitList.add(ItemUnit(1, "Gm"))

        var item = Item("Test", "CiTEM", "IMAGE", unitList, isSelected = false, isAdded = false)
        list.add(item)
        item = Item("Test", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Tesdft", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Tedfst", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Tedfst", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Teffst", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Teujjst", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Tesdft", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("jgf", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Test", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Tdfest", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Test", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("ddf", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Test", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("dfdf", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("Te6767st", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)
        item = Item("fgdfd", "CiTEM", "IMAGE", unitList, false, false)
        list.add(item)



        adapter = ItemListAdapter(list, this)
        recyclerViewItemList.adapter = adapter
        recyclerViewItemList.layoutManager = LinearLayoutManager(this)
        fagAddToCart.setOnClickListener {
            var size = adapter.getSelectedItem()!!.size
            if (size > 0) {
                Toast.makeText(this, "Selected $size Items Added Into the cart", Toast.LENGTH_LONG)
                    .show()
                adapter.itemsAdded()
            } else {
                Toast.makeText(this, "Please Select Items,to add into the cart", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun onItemSelect(item: Item?) {
        fagAddToCart.isVisible = adapter.getSelectedItem()!!.size > 0
    }

    companion object {
        fun getIntent(context: Context, shoppingListModel: ShoppingListModel): Intent {
            var intent = Intent(context, ItemsListActivity::class.java)
            intent.putExtra("item", shoppingListModel)
            return intent
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_item_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_cart -> startActivity(CartActivity.getIntent(this))
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }
}
