package com.dollee.market.dolleeMarket.catalog.infrastructure

import com.dollee.market.dolleeMarket.catalog.domain.Description
import jakarta.persistence.Embeddable

@Embeddable
data class Description(
    val text: String
) {
    fun toDomain(): Description = Description(text)
}
