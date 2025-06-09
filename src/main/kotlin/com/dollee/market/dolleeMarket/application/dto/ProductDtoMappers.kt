package com.dollee.market.dolleeMarket.application.dto

import com.dollee.market.dolleeMarket.product.domain.Product

fun Product.toResponse(): ProductListResponse {
    return ProductListResponse(
        productId = this.id ?: throw IllegalStateException("Product ID is null"),
        name = this.name,
        price = this.price
    )
}
