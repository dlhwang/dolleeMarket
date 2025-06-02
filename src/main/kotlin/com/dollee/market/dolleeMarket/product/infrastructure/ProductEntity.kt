package com.dollee.market.dolleeMarket.product.infrastructure

import com.dollee.market.dolleeMarket.product.domain.Product
import com.dollee.market.dolleeMarket.utills.NanoId
import jakarta.persistence.*

@Entity
@Table(name = "product")
class ProductEntity(
    @Id @NanoId
    val id: String? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Long
) {
    fun toDomain(): Product {
        return Product(id, name, price)
    }
}