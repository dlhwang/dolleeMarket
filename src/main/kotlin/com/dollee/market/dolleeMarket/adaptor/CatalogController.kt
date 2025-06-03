package com.dollee.market.dolleeMarket.adaptor

import com.dollee.market.dolleeMarket.application.dto.CatalogListResponse
import com.dollee.market.dolleeMarket.catalog.service.CatalogService
import jakarta.servlet.http.HttpServletRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/catalogs")
@Slf4j
class CatalogController(private val service : CatalogService) {

    val log: Logger = LoggerFactory.getLogger(CatalogController::class.java)

    @GetMapping
    fun getCatalogs(request :HttpServletRequest): ResponseEntity<MutableList<CatalogListResponse>> {
        log.info("{} {}", request.requestURI, request.remoteAddr)
        return ResponseEntity.ok(service.getCatalogList())
    }
}