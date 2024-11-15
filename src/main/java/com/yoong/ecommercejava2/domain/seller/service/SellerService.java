package com.yoong.ecommercejava2.domain.seller.service;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.common.ex.exception.ConflictException;
import com.yoong.ecommercejava2.common.ex.exception.ModelNotFoundException;
import com.yoong.ecommercejava2.domain.seller.dto.CreateSellerRequest;
import com.yoong.ecommercejava2.domain.seller.dto.SellerResponse;
import com.yoong.ecommercejava2.domain.seller.entity.Seller;
import com.yoong.ecommercejava2.domain.seller.repository.SellerRepository;
import com.yoong.ecommercejava2.domain.seller.shop.dto.CreateShopRequest;
import com.yoong.ecommercejava2.domain.seller.shop.dto.ShopResponse;
import com.yoong.ecommercejava2.domain.seller.shop.entity.Shop;
import com.yoong.ecommercejava2.domain.seller.shop.repository.ShopRepository;
import com.yoong.ecommercejava2.infra.security.config.PasswordConfig;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;
    private final ShopRepository shopRepository;
    private final PasswordConfig passwordConfig;

    @Transactional
    public DefaultResponse signUp(CreateSellerRequest createSellerRequest) {

        sellerRepository.save(new Seller(createSellerRequest, passwordConfig.encoder().encode(createSellerRequest.password())));

        return new DefaultResponse("판매자 회원 가입이 완료 되었습니다");
    }

    @Transactional
    public DefaultResponse createShop(Long sellerId,CreateShopRequest createShopRequest) {

        if(shopRepository.existsBySellerId(sellerId)) throw new ConflictException(409, "이미 상점이 존재 합니다");

        shopRepository.save(new Shop(createShopRequest));

        return new DefaultResponse("상점 생성이 완료 되었습니다");
    }
}
