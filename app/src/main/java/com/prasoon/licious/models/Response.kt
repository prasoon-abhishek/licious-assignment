package com.prasoon.licious.models

data class Response(
    val data: Data,
    val statusMessage: String,
    val statusCode: String
)

data class Data(
    val products: ArrayList<Product>
)

data class Product(
    val product_master: ProductMaster,
    val product_inventory: ProductInventory
)

data class ProductMaster(
    val product_id: String,
    val pr_name: String
)

data class ProductInventory(
    val availability_msg: String,
    val stock_units: String
)