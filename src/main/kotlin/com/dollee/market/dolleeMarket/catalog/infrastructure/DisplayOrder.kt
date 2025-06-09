package com.dollee.market.dolleeMarket.catalog.infrastructure

import com.dollee.market.dolleeMarket.catalog.domain.DisplayOrder

@JvmInline
value class DisplayOrder(val value: Int){
    init {
        require(value >= 0) { "DisplayOrder는 0 이상이어야 합니다." }
    }
    fun toDomain(): DisplayOrder = DisplayOrder(value)
}