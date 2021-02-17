package com.prasoon.licious

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.prasoon.licious.models.Response
import com.prasoon.licious.models.SecondaryActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = loadResponse()
        val res: Response = Gson().fromJson(response, Response::class.java)

        Log.d("parsed", res.toString())

        val adapter = LiciousAdapter(res) { inventory, master ->
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("id",master.product_id)
            intent.putExtra("name",master.pr_name)
            intent.putExtra("msg",inventory.availability_msg)
            intent.putExtra("stock",inventory.stock_units)
            startActivity(intent)
        }
        rvLicious.setHasFixedSize(true)
        rvLicious.layoutManager = LinearLayoutManager(this)
        rvLicious.adapter = adapter

    }

    private fun loadResponse(): String? {
        var json: String? = null
        json = try {
            val initialFile = this.getAssets().open("response.json")
//            val `is`: InputStream =  open("yourfilename.json")
            val size: Int = initialFile.available()
            val buffer = ByteArray(size)
            initialFile.read(buffer)
            initialFile.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}