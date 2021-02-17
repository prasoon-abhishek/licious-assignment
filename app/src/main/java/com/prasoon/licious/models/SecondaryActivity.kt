package com.prasoon.licious.models

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prasoon.licious.R
import kotlinx.android.synthetic.main.list_item.*

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        tvProductId.text = intent.getStringExtra("id")
        tvProductName.text = intent.getStringExtra("name")
        tvAvailabiltyMsg.text = intent.getStringExtra("msg")
        tvStockUnits.text = intent.getStringExtra("stock")
    }
}