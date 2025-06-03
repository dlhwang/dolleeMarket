package com.dollee.market.dolleeMarket.catalog.infrastructure

import java.io.Serializable

data class CatalogProductId (
    val catalogId: String,
    val productId: String
) : Serializable