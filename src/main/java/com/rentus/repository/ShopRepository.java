package com.rentus.repository;

import com.rentus.models.Shop;

import java.util.List;

public interface ShopRepository {
    void register(Shop shop);
    Shop login(Shop shop);
    List<Shop> allShops();
    Shop getShopById(int id);
//    boolean approveShops(int id);
}
