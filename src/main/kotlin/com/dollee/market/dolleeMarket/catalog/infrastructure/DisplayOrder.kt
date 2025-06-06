package com.dollee.market.dolleeMarket.catalog.infrastructure

@JvmInline
value class DisplayOrder(val value: Int){
    init {
        require(value >= 0) { "DisplayOrder는 0 이상이어야 합니다." }
    }
}