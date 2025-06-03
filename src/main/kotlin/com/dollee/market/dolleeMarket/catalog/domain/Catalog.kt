package com.dollee.market.dolleeMarket.catalog.domain

import com.dollee.market.dolleeMarket.catalog.infrastructure.CatalogEntity

class Catalog(
    val id: String,
    val name: String,
    val items: MutableList<CatalogProduct>
) {
    fun toEntity(): CatalogEntity {
        return CatalogEntity(id, name)
    }
}