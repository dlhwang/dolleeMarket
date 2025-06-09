package com.dollee.market.dolleeMarket.catalog.service

import com.dollee.market.dolleeMarket.application.dto.CatalogListResponse
import com.dollee.market.dolleeMarket.catalog.domain.CatalogRepository
import org.springframework.stereotype.Service

@Service
class CatalogService(private val repository: CatalogRepository) {

    fun getCatalogList() : MutableList<CatalogListResponse>{
        return repository.findAll()
            .map { catalog -> CatalogListResponse(catalog.id.toString()) }
            .toMutableList()
    }
}