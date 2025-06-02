package com.dollee.market.dolleeMarket.product.domain

interface ProductRepository {
    fun save(product: Product): Product
    fun findAll(): List<Product>
    fun findById(id: String): Product?
}