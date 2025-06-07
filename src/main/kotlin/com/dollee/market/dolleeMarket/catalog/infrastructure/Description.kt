package com.dollee.market.dolleeMarket.catalog.infrastructure

import com.dollee.market.dolleeMarket.catalog.domain.Description

data class Description(
    val text: String
) {
    fun toDomain(): Description = Description(text)
}
