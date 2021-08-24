package com.rentus.services;

import com.rentus.models.Shop;

import java.util.List;

public interface ShopService {
    void register(Shop shop);
    Shop login(Shop shop);
    List<Shop> getShops();

}
