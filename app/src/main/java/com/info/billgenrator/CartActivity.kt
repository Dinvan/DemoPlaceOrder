package com.info.billgenrator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        supportActionBar?.let {
            it.title="Your Cart"
        }
        var adapter = CartAdapter(ArrayList<CartItem>(), this)
        recyclerViewItemList.adapter = adapter
        recyclerViewItemList.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            var intent = Intent(context, CartActivity::class.java)
            return intent
        }
    }
}
