package com.dollee.market.dolleeMarket.product.service

import com.dollee.market.dolleeMarket.application.dto.ProductListResponse
import com.dollee.market.dolleeMarket.application.dto.toResponse
import com.dollee.market.dolleeMarket.product.domain.Product
import com.dollee.market.dolleeMarket.product.domain.ProductRepository
import com.dollee.market.dolleeMarket.application.dto.CreateProductCommand
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getProductList() : MutableList<ProductListResponse>{
        return productRepository.findAll()
            .map { product -> ProductListResponse(product.id!!, product.name, product.price) }
            .toMutableList()
    }

    fun saveProduct(command : CreateProductCommand) : ProductListResponse{
        return productRepository.save(Product(name =command.name,price = command.price)).toResponse()
    }
}