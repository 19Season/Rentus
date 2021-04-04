package com.rentus.repository;

import com.rentus.models.Shop;

public interface ShopRepository {
    void register(Shop shop);
    Boolean login(Shop shop);

}
