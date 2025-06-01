package com.dollee.market.dolleeMarket.domain.product.service

import com.dollee.market.dolleeMarket.application.dto.ProductListResponse
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun getProductList() : MutableList<ProductListResponse>{
        return mutableListOf()
    }
}