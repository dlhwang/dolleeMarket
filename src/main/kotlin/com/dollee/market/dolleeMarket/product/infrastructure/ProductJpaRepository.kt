package com.dollee.market.dolleeMarket.product.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<ProductEntity, String> {
}