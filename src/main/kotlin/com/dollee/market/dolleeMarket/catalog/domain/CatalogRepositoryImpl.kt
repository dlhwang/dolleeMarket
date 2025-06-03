package com.dollee.market.dolleeMarket.catalog.domain

import com.dollee.market.dolleeMarket.catalog.infrastructure.CatalogJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CatalogRepositoryImpl(private val jpaRepository: CatalogJpaRepository) : CatalogRepository {
    override fun save(catalog: Catalog): Catalog {
        val entity = catalog.toEntity()
        val saved = jpaRepository.save(entity)
        return saved.toDomain()
    }

    override fun findAll(): List<Catalog> {
        return jpaRepository.findAll().map { it.toDomain() }
    }

    override fun findById(id: String): Catalog? {
        return jpaRepository.findById(id).orElse(null)?.toDomain()
    }
}