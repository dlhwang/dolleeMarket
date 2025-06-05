package com.dollee.market.dolleeMarket.catalog.infrastructure

import java.time.LocalDateTime

data class Metadata(
    val isActive: Boolean,
    val activeDate: LocalDateTime
)
