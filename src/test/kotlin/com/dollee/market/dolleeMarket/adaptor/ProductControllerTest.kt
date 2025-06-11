package com.dollee.market.dolleeMarket.adaptor

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import com.dollee.market.dolleeMarket.application.dto.CreateProductCommand
import com.dollee.market.dolleeMarket.application.dto.ProductListResponse
import com.dollee.market.dolleeMarket.application.dto.toResponse
import com.dollee.market.dolleeMarket.product.domain.Product
import com.dollee.market.dolleeMarket.product.service.ProductService
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@AutoConfigureMockMvc
@WebMvcTest(ProductController::class)
@DisplayName("ProductController 테스트")
class ProductControllerTest: BehaviorSpec({
    val objectMapper = ObjectMapper()
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

    given("상품 등록 API") {
        val request = CreateProductCommand(name = "테스트 상품", price = 15000)

        every { mockService.saveProduct(request) } returns product.toResponse()


        val jsonRequest = objectMapper.writeValueAsString(request)

        `when`("올바른 요청이 들어오면") {
            then("201 Created를 반환한다") {
                mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
                ).andExpect(status().isCreated)
            }
        }
    }


})