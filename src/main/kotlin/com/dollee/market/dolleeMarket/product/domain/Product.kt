package com.dollee.market.dolleeMarket.product.domain

import com.dollee.market.dolleeMarket.product.infrastructure.ProductEntity

data class Product (
    val id: String?,
    val name: String,
    val price: Long
) {
    fun toEntity(): ProductEntity {
        return ProductEntity(id, name, price)
    }
}