package com.info.billgenrator

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.title="My List"
        }
        var list=ArrayList<ShoppingListModel>()
        list.add(ShoppingListModel(4,"Grocery"))
        list.add(ShoppingListModel(3,"F"))
        list.add(ShoppingListModel(8,"Test 5"))
        list.add(ShoppingListModel(8,"Test 1r"))
        list.add(ShoppingListModel(2,"Test 1e"))
        list.add(ShoppingListModel(8,"Test q1"))

        var adapter=ShoppingListAdapter(list,this)
        recyclerViewShoppingList.adapter=adapter
        recyclerViewShoppingList.layoutManager=LinearLayoutManager(this)

        fab.setOnClickListener { view ->

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
