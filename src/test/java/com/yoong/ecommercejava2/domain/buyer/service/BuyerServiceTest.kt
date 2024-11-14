package com.yoong.ecommercejava2.domain.buyer.service

import com.yoong.ecommercejava2.common.dto.DefaultResponse
import com.yoong.ecommercejava2.common.ex.exception.ModelNotFoundException
import com.yoong.ecommercejava2.common.ex.exception.PasswordException
import com.yoong.ecommercejava2.domain.buyer.dto.request.CreateBuyerRequest
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerImageRequest
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerPasswordRequest
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerProfileRequest
import com.yoong.ecommercejava2.domain.buyer.entity.Buyer
import com.yoong.ecommercejava2.domain.buyer.repository.BuyerRepository
import com.yoong.ecommercejava2.infra.security.config.PasswordConfig
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import java.util.*

class BuyerServiceTest : StringSpec({

        val buyerRepository = mockk<BuyerRepository>()
        val passwordConfig = mockk<PasswordConfig>()
        val buyerService = BuyerService(buyerRepository, passwordConfig)

        "사용자 회원 가입 정상 성공"{
            //given

            val createBuyerRequest = CreateBuyerRequest(
                1L,
                "test",
                "test",
                "test",
                "test",
                "test",
                "test"
            )

            val buyer = Buyer(createBuyerRequest, "testPw")

            //when

            every { passwordConfig.encoder().encode(createBuyerRequest.password) } returns "testPw"
            every { buyerRepository.save(buyer) } returns buyer
            every { buyerRepository.findById(1L) } returns Optional.of(buyer)

            val result = buyerService.signUp(createBuyerRequest)

            val resultBuyer = buyerRepository.findById(1L)

            result shouldBe DefaultResponse("구매자 생성이 완료 되었습니다")
            resultBuyer.get().email shouldBe "test"
            resultBuyer.get().password shouldBe "testPw"
            resultBuyer.get().nickname shouldBe "test"
            resultBuyer.get().profileImage shouldBe "test"
            resultBuyer.get().phoneNumber shouldBe "test"
            resultBuyer.get().address shouldBe "test"


        }

        "내 프로필 조회 시에 프로필이 없을 경우 ModelNotFountException"{

            every { buyerRepository.findById(1L) } returns Optional.empty()

            shouldThrow<ModelNotFoundException> {
                buyerService.getMyProfile(1L)
            }.let{
                it.errorCode shouldBe 404
                it.message shouldBe "존재하지 않는 구매자 입니다"
            }
        }

        "내 프로필 조회 시에 정상 조회"{
            val createBuyerRequest = CreateBuyerRequest(
                1L,
                "test",
                "test2",
                "test3",
                "test4",
                "test5",
                "test6"
            )

            val buyer = Buyer(createBuyerRequest, "testPw")

            every { buyerRepository.save(buyer) } returns buyer
            every { buyerRepository.findById(any()) } returns Optional.of(buyer)

            val result = buyerService.getMyProfile(buyer.id)

            result.id shouldBe buyer.id
            result.nickname shouldBe "test"
            result.email shouldBe "test3"
            result.profileImage shouldBe "test4"
            result.phoneNumber shouldBe "test5"
            result.address shouldBe "test6"

        }

        "비밀번호 변경 시에 변경 예정 비밀번호가 일치 하지 않으면 PasswordException"{

            val updateBuyerPasswordRequest = UpdateBuyerPasswordRequest(
                "test",
                "test2",
                "test3",
            )

            shouldThrow<PasswordException> {
                buyerService.changePassword(updateBuyerPasswordRequest, 1L)
            }.let{
                it.errorCode shouldBe 401
                it.message shouldBe "비밀번호가 일치 하지 않습니다 다시 시도 해주세요"
            }

        }

        "비밀번호 변경 정상 성공"{

            //given

            val createBuyerRequest = CreateBuyerRequest(
                1L,
                "test",
                "test",
                "test",
                "test",
                "test",
                "test"
            )

            val buyer = Buyer(createBuyerRequest, "testPw")

            val updateBuyerPasswordRequest = UpdateBuyerPasswordRequest(
                "test",
                "test2",
                "test2",
            )

            //When
            every { buyerRepository.save(buyer) } returns buyer
            every { buyerRepository.findById(any()) } returns Optional.of(buyer)
            every { passwordConfig.validPassword(any(), any()) } returns "testPw2"
            every { buyerRepository.findById(any()) } returns Optional.of(buyer)

            val result = buyerService.changePassword(updateBuyerPasswordRequest, buyer.id)

            val resultBuyer = buyerRepository.findById(buyer.id)

            //Then
            result shouldBe DefaultResponse("패스워드 변경이 완료 되었습니다")
            resultBuyer.get().password shouldBe "testPw2"
        }

        "이미지 변경 정상 성공"{

        //given

        val createBuyerRequest = CreateBuyerRequest(
            1L,
            "test",
            "test",
            "test",
            "test",
            "test",
            "test"
        )

        val buyer = Buyer(createBuyerRequest, "testPw")

        val updateBuyerImageRequest = UpdateBuyerImageRequest(
            "test77",
        )

        //When
        every { buyerRepository.save(buyer) } returns buyer
        every { buyerRepository.findById(any()) } returns Optional.of(buyer)


        val result = buyerService.changeImage(updateBuyerImageRequest, buyer.id)

        every { buyerRepository.findById(any()) } returns Optional.of(buyer)

        val resultBuyer = buyerRepository.findById(buyer.id)

        //Then
        result shouldBe DefaultResponse("이미지 변경이 완료 되었습니다")
        resultBuyer.get().profileImage shouldBe "test77"
    }

        "프로필 변경 정상 성공"{

        //given

        val createBuyerRequest = CreateBuyerRequest(
            1L,
            "test",
            "test",
            "test",
            "test",
            "test",
            "test"
        )

        val buyer = Buyer(createBuyerRequest, "testPw")

        val updateBuyerProfileRequest = UpdateBuyerProfileRequest(
            "test",
            "test2",
            "test3",
        )

        //When
        every { buyerRepository.save(buyer) } returns buyer
        every { buyerRepository.findById(any()) } returns Optional.of(buyer)


        val result = buyerService.changeProfile(updateBuyerProfileRequest, buyer.id)
        every { buyerRepository.findById(any()) } returns Optional.of(buyer)
        val resultBuyer = buyerRepository.findById(buyer.id)

        //Then
        result shouldBe DefaultResponse("프로필 변경이 완료 되었습니다")
        resultBuyer.get().nickname shouldBe "test"
        resultBuyer.get().phoneNumber shouldBe "test2"
        resultBuyer.get().address shouldBe "test3"
    }
}){


}
