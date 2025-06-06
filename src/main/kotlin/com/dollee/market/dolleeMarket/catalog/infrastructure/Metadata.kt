package com.dollee.market.dolleeMarket.catalog.infrastructure

import com.dollee.market.dolleeMarket.catalog.domain.Metadata
import java.time.LocalDateTime

data class Metadata(
    val isActive: Boolean,
    val activeDate: LocalDateTime
) {
    fun toDomain(): Metadata {}
}
