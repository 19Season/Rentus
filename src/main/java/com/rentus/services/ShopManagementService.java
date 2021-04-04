package com.rentus.services;

import com.rentus.models.Shop;
import com.rentus.repository.ShopRepository;
import com.rentus.utility.RepoFactory;

public class ShopManagementService implements ShopService {
    private ShopRepository shopRepo;

    public ShopManagementService(){
         this.shopRepo = RepoFactory.getShopRepo();
     }


    @Override
    public void register(Shop shop) {
        shopRepo.register(shop);
    }

   @Override
    public Boolean login(Shop shop) {
        shopRepo.login(shop);
        return true;
    }
}
