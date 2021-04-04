package com.rentus.services;

import com.rentus.models.Shop;

public interface ShopService {
    void register(Shop shop);
    Boolean login(Shop shop);

}
