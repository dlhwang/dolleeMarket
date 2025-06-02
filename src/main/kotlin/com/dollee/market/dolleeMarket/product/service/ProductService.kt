package com.dollee.market.dolleeMarket.product.service

import com.dollee.market.dolleeMarket.application.dto.ProductListResponse
import com.dollee.market.dolleeMarket.product.domain.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getProductList() : MutableList<ProductListResponse>{
        return productRepository.findAll()
            .map { product -> ProductListResponse(product.id!!, product.name, product.price) }
            .toMutableList()
    }
}