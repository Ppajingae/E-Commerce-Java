package com.yoong.ecommercejava2.domain.favorite.controller;

import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.domain.favorite.dto.FavoriteResponse;
import com.yoong.ecommercejava2.domain.favorite.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/favorite")
@RequiredArgsConstructor
public class FavoriteController {


    private final FavoriteService favoriteService;

    @PostMapping("/{productId}")
    public ResponseEntity<DefaultResponse> favoriteManagement(
            @PathVariable Long productId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(favoriteService.favoriteManagement(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<DefaultResponse> favoriteDelete(
            @PathVariable Long productId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(favoriteService.favoriteDelete(productId));
    }

    @GetMapping()
    public ResponseEntity<List<FavoriteResponse>> getFavorites(){
        return ResponseEntity.status(HttpStatus.OK).body(favoriteService.getFavorites());
    }
}


//@PreAuthorize("hasRole('BUYER')")
//@GetMapping()
//fun getFavorites(
//        @AuthenticationPrincipal user: UserPrincipal
//): ResponseEntity<List<FavoriteResponse>> = ResponseEntity
//        .status(HttpStatus.OK)
//        .body(favoriteService.getFavorites(user.id))