package com.yoong.ecommercejava2.domain.seller.service

import com.yoong.ecommercejava2.common.dto.DefaultResponse
import com.yoong.ecommercejava2.common.ex.exception.ConflictException
import com.yoong.ecommercejava2.domain.seller.dto.CreateSellerRequest
import com.yoong.ecommercejava2.domain.seller.entity.Seller
import com.yoong.ecommercejava2.domain.seller.repository.SellerRepository
import com.yoong.ecommercejava2.domain.seller.shop.dto.CreateShopRequest
import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop
import com.yoong.ecommercejava2.domain.seller.shop.repository.ShopRepository
import com.yoong.ecommercejava2.infra.security.config.PasswordConfig
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

class SellerServiceTest : StringSpec({

    val sellerRepository = mockk<SellerRepository>()
    val shopRepository = mockk<ShopRepository>()
    val passwordConfig = mockk<PasswordConfig>()
    val sellerService = SellerService(sellerRepository, shopRepository, passwordConfig)

    "판매자 회원 가입 정상 동작"{

        val createSellerRequest = CreateSellerRequest(
            1L,
            "test",
            "test",
            "test",
            "test",
            "test",
        )

        val seller = Seller(createSellerRequest, "testPw")

        every { passwordConfig.encoder().encode(createSellerRequest.password) } returns "testPw"
        every { sellerRepository.save(seller) } returns seller
        every { sellerRepository.findById(seller.id) } returns Optional.of(seller)

        val result = sellerService.signUp(createSellerRequest)

        val resultSeller = sellerRepository.findById(seller.id)

        result shouldBe DefaultResponse("판매자 회원 가입이 완료 되었습니다")
        resultSeller.get().email shouldBe "test"
        resultSeller.get().password shouldBe "testPw"
        resultSeller.get().address shouldBe "test"
        resultSeller.get().phoneNumber shouldBe "test"
        resultSeller.get().nickname shouldBe "test"
    }
    "판매자 상점이 있을 경우 ConflictException"{

        val createShopRequest = CreateShopRequest(
            "test",
            "test",
            "test",
        )

        every { shopRepository.existsBySellerId(any()) } returns true

        shouldThrow<ConflictException> {
            sellerService.createShop(1L, createShopRequest)
        }.let{
            it.errorCode shouldBe 409
            it.message shouldBe "이미 상점이 존재 합니다"
        }
    }
    "판매자 상점 정상 생성"{

    val createShopRequest = CreateShopRequest(
        "test",
        "test",
        "test",
    )

    val shop = Shop(createShopRequest)

    every { shopRepository.existsBySellerId(any()) } returns false
    every { shopRepository.save(shop) } answers {
        shop.id = 1L
        shop
    }
    every { shopRepository.findById(any()) } returns Optional.of(shop)

    val result = sellerService.createShop(1L, createShopRequest)
    val resultShop = shopRepository.findById(shop.id)

    result shouldBe DefaultResponse("상점 생성이 완료 되었습니다")
    resultShop.get().name shouldBe "test"
    resultShop.get().description shouldBe "test"
    resultShop.get().shopImage shouldBe "test"
}
})
