package com.dollee.market.dolleeMarket.application.dto

import com.dollee.market.dolleeMarket.product.domain.Product

data class ProductListResponse(val productId: String, var name: String, var price: Long){
    fun Product.toResponse(product: Product): ProductListResponse {
        return ProductListResponse(
            productId = product.id ?: throw IllegalStateException("Product ID is null"),
            name = product.name,
            price = product.price
        )
    }

}