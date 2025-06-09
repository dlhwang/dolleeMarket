package com.dollee.market.dolleeMarket.adaptor

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.dollee.market.dolleeMarket.application.dto.ProductListResponse
import com.dollee.market.dolleeMarket.product.domain.Product
import com.dollee.market.dolleeMarket.product.service.ProductService
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest(ProductController::class)
@DisplayName("ProductController 테스트")
class ProductControllerTest : BehaviorSpec({
    val mockService = mockk<ProductService>()
    var productId = NanoIdUtils.randomNanoId()
    val product = Product(id = productId, name = "빼빼로", price = 1_000)
    val mockMvc = MockMvcBuilders
        .standaloneSetup(ProductController(mockService))
        .build()

    given("상품 목록이 존재할 때") {
        every { mockService.getProductList() } returns listOf(product).map { it ->
            ProductListResponse(
                it.id!!,
                it.name,
                it.price
            )
        }.toMutableList()

        `when`("GET /api/v1/products 요청 시") {
            then("200 OK와 상품 목록을 반환한다") {
                mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products"))
                    .andExpect(status().isOk)
                    .andExpect(jsonPath("$[0].name").value("빼빼로"))
                    .andExpect(jsonPath("$[0].price").value(1_000))
            }
        }
    }

})