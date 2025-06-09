package com.dollee.market.dolleeMarket.catalog.infrastructure

import com.dollee.market.dolleeMarket.catalog.domain.Metadata
import jakarta.persistence.Embeddable
import java.time.LocalDateTime

@Embeddable
data class Metadata(
    val isActive: Boolean,
    val activeDate: LocalDateTime
) {
    fun toDomain(): Metadata = Metadata(isActive, activeDate)
}
