package com.dollee.market.dolleeMarket.application.dto

data class CreateProductCommand(
    val name: String,
    val price: Long
)