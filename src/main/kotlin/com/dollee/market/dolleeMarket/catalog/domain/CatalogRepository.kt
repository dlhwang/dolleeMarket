package com.dollee.market.dolleeMarket.catalog.domain

interface CatalogRepository {
    fun save(catalog: Catalog): Catalog
    fun findAll(): List<Catalog>
    fun findById(id: String): Catalog?
}