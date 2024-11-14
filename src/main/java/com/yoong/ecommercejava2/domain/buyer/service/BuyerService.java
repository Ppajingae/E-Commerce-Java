package com.yoong.ecommercejava2.domain.buyer.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.common.ex.exception.ModelNotFoundException;
import com.yoong.ecommercejava2.common.ex.exception.PasswordException;
import com.yoong.ecommercejava2.domain.buyer.dto.BuyerResponse;
import com.yoong.ecommercejava2.domain.buyer.dto.request.CreateBuyerRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerImageRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerPasswordRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerProfileRequest;
import com.yoong.ecommercejava2.domain.buyer.entity.Buyer;
import com.yoong.ecommercejava2.domain.buyer.repository.BuyerRepository;
import com.yoong.ecommercejava2.infra.security.config.PasswordConfig;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;
    private final PasswordConfig passwordConfig;

    @Transactional
    public DefaultResponse signUp(CreateBuyerRequest createBuyerRequest) {

        buyerRepository.save(new Buyer(createBuyerRequest, passwordConfig.encoder().encode(createBuyerRequest.password())));

        return new DefaultResponse("구매자 생성이 완료 되었습니다");
    }

    public BuyerResponse getMyProfile(Long id) {

        Buyer buyer = buyerRepository.findById(id).orElse(null);

        if (buyer == null) {
            throw new ModelNotFoundException(
                    404, "존재하지 않는 구매자 입니다"
            );
        }

        return BuyerResponse.from(buyer);
    }

    @Transactional
    public DefaultResponse changePassword(UpdateBuyerPasswordRequest updateBuyerPasswordRequest, Long id) {

        if(!updateBuyerPasswordRequest.newPassword().equals(updateBuyerPasswordRequest.retryPassword())) throw new PasswordException(401, "비밀번호가 일치 하지 않습니다 다시 시도 해주세요");

        Buyer buyer = buyerRepository.findById(id).orElse(null);

        if (buyer == null)  {
            throw new ModelNotFoundException(
                    404, "존재하지 않는 구매자 입니다"
            );
        }


        String newPassword = passwordConfig.validPassword(buyer.getPassword(), updateBuyerPasswordRequest);

        buyer.passwordUpdate(newPassword);

        return new DefaultResponse("패스워드 변경이 완료 되었습니다");
    }

    @Transactional
    public DefaultResponse changeImage(UpdateBuyerImageRequest updateBuyerImageRequest, Long id) {

        Buyer buyer = buyerRepository.findById(id).orElse(null);

        if (buyer == null) {
            throw new ModelNotFoundException(
                    404, "존재하지 않는 구매자 입니다"
            );
        }

        buyer.updateImage(updateBuyerImageRequest.imageUrl());

        return new DefaultResponse("이미지 변경이 완료 되었습니다");
    }

    @Transactional
    public DefaultResponse changeProfile(UpdateBuyerProfileRequest updateBuyerProfileRequest, Long id) {

        Buyer buyer = buyerRepository.findById(id).orElse(null);

        if (buyer == null) {
            throw new ModelNotFoundException(
                    404, "존재하지 않는 구매자 입니다"
            );
        }

        buyer.updateProfile(updateBuyerProfileRequest);

        return new DefaultResponse("프로필 변경이 완료 되었습니다");
    }
}
