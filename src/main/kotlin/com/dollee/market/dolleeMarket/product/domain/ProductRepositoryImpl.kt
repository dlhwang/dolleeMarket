package com.dollee.market.dolleeMarket.product.domain

import com.dollee.market.dolleeMarket.product.infrastructure.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(private val jpaRepository: ProductJpaRepository) : ProductRepository {
    override fun save(product: Product): Product {
        val entity = product.toEntity()
        val saved = jpaRepository.save(entity)
        return saved.toDomain()
    }

    override fun findAll(): List<Product> {
        return jpaRepository.findAll().map { it.toDomain() }
    }

    override fun findById(id: String): Product? {
        return jpaRepository.findById(id).orElse(null)?.toDomain()
    }
}