package com.yoong.ecommercejava2.domain.favorite.repository;

import com.yoong.ecommercejava2.domain.favorite.dto.FavoriteCount;

import java.util.Collection;
import java.util.List;

public interface FavoriteRepository {

    List<FavoriteCount> favoritesCount(Collection<Long> productIds);
}
