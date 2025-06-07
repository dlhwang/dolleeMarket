package com.dollee.market.dolleeMarket.catalog.domain

import com.dollee.market.dolleeMarket.catalog.infrastructure.CatalogEntity

class Catalog(
    val id: CatalogId,
    val name: String,

    val description: Description,
    val metadata: Metadata,
    val displayOrder: DisplayOrder,

    val parentId: CatalogId?,
    val children: List<CatalogId> = emptyList(),
    val productIds: List<ProductId> = emptyList()

) {

    fun toEntity(parent: CatalogEntity?): CatalogEntity = CatalogEntity(
        id = id.value,
        name = name,
        parent = parent,
        description = com.dollee.market.dolleeMarket.catalog.infrastructure.Description(description.text),
        metadata = com.dollee.market.dolleeMarket.catalog.infrastructure.Metadata(metadata.isActive, metadata.activeDate),
        displayOrder = com.dollee.market.dolleeMarket.catalog.infrastructure.DisplayOrder(displayOrder.value)
    )

}