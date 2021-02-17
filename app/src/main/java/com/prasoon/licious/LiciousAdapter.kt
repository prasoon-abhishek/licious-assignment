package com.prasoon.licious

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.prasoon.licious.models.ProductInventory
import com.prasoon.licious.models.ProductMaster
import com.prasoon.licious.models.Response
import kotlinx.android.synthetic.main.list_item.view.*


class LiciousAdapter(
    val response: Response,
    val onItemClick: (inventory: ProductInventory, master: ProductMaster) -> Unit
) : RecyclerView.Adapter<LiciousAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvProductId = view.tvProductId
        val tvProductName = view.tvProductName
        val tvAvailabiltyMsg = view.tvAvailabiltyMsg
        val tvStockUnits = view.tvStockUnits
        val cvParent = view.cvParent
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return response.data.products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvProductId.text =
            response.data.products[position].product_master.product_id
        holder.tvProductName.text =
            response.data.products[position].product_master.pr_name
        holder.tvAvailabiltyMsg.text =
            response.data.products[position].product_inventory.availability_msg
        holder.tvStockUnits.text =
            response.data.products[position].product_inventory.stock_units
        holder.cvParent.setOnClickListener {
            onItemClick.invoke(
                response.data.products[position].product_inventory,
                response.data.products[position].product_master
            )
        }
    }


}