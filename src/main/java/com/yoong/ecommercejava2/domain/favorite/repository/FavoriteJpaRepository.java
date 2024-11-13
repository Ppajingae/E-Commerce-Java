package com.yoong.ecommercejava2.domain.favorite.repository;

import com.yoong.ecommercejava2.domain.favorite.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteJpaRepository extends JpaRepository<Favorite, Long> {

    @Modifying
    @Query("delete from Favorite f where f.productId = :productId and f.buyerId = :buyerId")
    void deleteFavorite(Long productId, Long buyerId);

    List<Favorite> findAllByBuyerId(Long buyerId);

    int countFavoriteByProductId(Long productId);
}

