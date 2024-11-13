package com.yoong.ecommercejava2.domain.favorite.repository;

import com.yoong.ecommercejava2.domain.favorite.dto.FavoriteCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FavoriteRepositoryImpl implements FavoriteRepository {

    private final FavoriteJpaRepository favoriteJpaRepository;

    @Override
    public List<FavoriteCount> favoritesCount(Collection<Long> productIds) {
        return null;
    }
}
