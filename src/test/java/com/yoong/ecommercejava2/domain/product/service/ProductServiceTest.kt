package com.yoong.ecommercejava2.domain.product.service

import com.yoong.ecommercejava2.common.dto.DefaultResponse
import com.yoong.ecommercejava2.common.ex.exception.ModelNotFoundException
import com.yoong.ecommercejava2.domain.backoffice.dto.product_backoffice.ProductBackOfficeRequest
import com.yoong.ecommercejava2.domain.backoffice.entity.ProductBackOffice
import com.yoong.ecommercejava2.domain.backoffice.repository.ProductBackOfficeRepository
import com.yoong.ecommercejava2.domain.product.dto.CreateProductRequest
import com.yoong.ecommercejava2.domain.product.dto.UpdateProductRequest
import com.yoong.ecommercejava2.domain.product.entity.Product
import com.yoong.ecommercejava2.domain.product.repository.ProductRepository
import com.yoong.ecommercejava2.domain.seller.repository.SellerRepository
import com.yoong.ecommercejava2.domain.seller.shop.dto.CreateShopRequest
import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop
import com.yoong.ecommercejava2.domain.seller.shop.repository.ShopRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

class ProductServiceTest : StringSpec({

    val productRepository = mockk<ProductRepository>()
    val shopRepository = mockk<ShopRepository>()
    val sellerRepository = mockk<SellerRepository>()
    val productBackOfficeRepository = mockk<ProductBackOfficeRepository>()
    val productService = ProductService(
        productRepository,
        shopRepository,
        sellerRepository,
        productBackOfficeRepository
    )

    "상품 정보가 존재하지 않을 경우 ModelNotFoundException"{

        val createProductRequest = CreateProductRequest(
            "test",
            "test",
            0L,
            "test"
        )

        val productBackOfficeRequest = ProductBackOfficeRequest(
            0,
            0
        )

        every { shopRepository.findBySellerId(any()) } returns Optional.empty()

        shouldThrow<ModelNotFoundException> {
            productService.createProduct(createProductRequest, productBackOfficeRequest,1L)
        }.let{
            it.errorCode shouldBe 404
            it.message shouldBe "상점 정보가 존재하지 않습니다"
        }
    }

    "상품 정보 정상 등록"{

        val createProductRequest = CreateProductRequest(
            "test",
            "test2",
            1L,
            "test3"
        )

        val productBackOfficeRequest = ProductBackOfficeRequest(
            20,
            20000
        )

        val createShopRequest = CreateShopRequest(
            "myShop",
            "testD",
            "testE"
        )

        val shop = Shop(
            createShopRequest,
            1L
        )

        val product = Product(
            createProductRequest,
            shop
        )

        val productBackOffice = ProductBackOffice(
            productBackOfficeRequest,
            product
        )

        every { shopRepository.findBySellerId(any()) } returns  Optional.of(shop)
        every { productRepository.saveAndFlush(any()) } returns product
        every { productBackOfficeRepository.save(any()) } returns productBackOffice
        every { productRepository.findById(any()) } answers {
            Optional.of(product)
        }

        val result = productService.createProduct(createProductRequest, productBackOfficeRequest,1L)
        val resultProduct = productRepository.findById(product.id)

        result shouldBe DefaultResponse("상품 생성이 완료 되었습니다")
        resultProduct.get().name shouldBe "test"
        resultProduct.get().description shouldBe "test2"
        resultProduct.get().categoryId shouldBe 1L
        resultProduct.get().productImage shouldBe "test3"
        resultProduct.get().productBackOffice.quantity shouldBe 20
        resultProduct.get().productBackOffice.price shouldBe 20000


    }

    "상품 정보 정상 수정"{

        val createProductRequest = CreateProductRequest(
            "test",
            "test2",
            1L,
            "test3"
        )

        val createShopRequest = CreateShopRequest(
            "myShop",
            "testD",
            "testE"
        )

        val shop = Shop(
            createShopRequest,
            1L
        )

        val product = Product(
            createProductRequest,
            shop
        )

        val updateProductRequest = UpdateProductRequest(
            "String",
            "String2",
            false,
            2L
        )

        every { productRepository.findById(any()) } returns Optional.of(product)

        val result = productService.updateProduct(1L, updateProductRequest)
        val resultProduct = productRepository.findById(product.id)

        result shouldBe DefaultResponse("상품 정보 수정이 완료 되었습니다")
        resultProduct.get().name shouldBe "String"
        resultProduct.get().description shouldBe "String2"
        resultProduct.get().categoryId shouldBe 2L
        resultProduct.get().isSoldOut shouldBe false
    }

    "상품 정보 정상 삭제"{

        val createProductRequest = CreateProductRequest(
            "test",
            "test2",
            1L,
            "test3"
        )

        val createShopRequest = CreateShopRequest(
            "myShop",
            "testD",
            "testE"
        )

        val shop = Shop(
            createShopRequest,
            1L
        )

        val product = Product(
            createProductRequest,
            shop
        )


        every { productRepository.findById(any()) } returns Optional.of(product)

        val result = productService.deleteProduct(1L)
        val resultProduct = productRepository.findById(product.id)

        result shouldBe DefaultResponse("상품 삭제가 완료 되었습니다")
        resultProduct.get().isDeleted shouldBe true
    }

    "상품 정보 정상 조회"{

        val createProductRequest = CreateProductRequest(
            "test",
            "test2",
            1L,
            "test3"
        )

        val productBackOfficeRequest = ProductBackOfficeRequest(
            20,
            20000
        )

        val createShopRequest = CreateShopRequest(
            "myShop",
            "testD",
            "testE"
        )

        val shop = Shop(
            createShopRequest,
            1L
        )

        val product = Product(
            createProductRequest,
            shop
        )

        val productBackOffice = ProductBackOffice(
            productBackOfficeRequest,
            product
        )

        product.savedProductBackOffice(productBackOffice)

        every { productRepository.findById(any()) } returns Optional.of(product)

        val result = productService.getProductById(1L)

        result.id shouldBe product.id
        result.name shouldBe "test"
        result.description shouldBe "test2"
        result.categoryId shouldBe 1L
        result.price shouldBe 20000
        result.isSoldOut shouldBe false
        result.likes shouldBe 0
    }

})
