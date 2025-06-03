package com.dollee.market.dolleeMarket.catalog.infrastructure

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "catalog_product")
class CatalogProductEntity (
    @EmbeddedId
    val id: CatalogProductId,
    val displayOrder: Int
)