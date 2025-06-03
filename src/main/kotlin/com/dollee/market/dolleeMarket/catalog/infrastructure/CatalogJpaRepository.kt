package com.dollee.market.dolleeMarket.catalog.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface CatalogJpaRepository : JpaRepository<CatalogEntity, String> {
}