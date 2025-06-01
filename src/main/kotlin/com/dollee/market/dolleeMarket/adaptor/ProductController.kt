package com.dollee.market.dolleeMarket.adaptor

import com.dollee.market.dolleeMarket.application.dto.ProductListResponse
import com.dollee.market.dolleeMarket.product.service.ProductService
import jakarta.servlet.http.HttpServletRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/products")
@Slf4j
class ProductController(private val service : ProductService) {

    val log: Logger = LoggerFactory.getLogger(ProductController::class.java)

    @GetMapping
    fun getCourses(request :HttpServletRequest): ResponseEntity<MutableList<ProductListResponse>> {
        log.info("{} {}", request.requestURI, request.remoteAddr)
        return ResponseEntity.ok(service.getProductList())
    }
}