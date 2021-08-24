package com.rentus.services;

import com.rentus.models.Shop;
import com.rentus.repository.ShopRepository;
import com.rentus.utility.RepoFactory;

import java.util.List;

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
    public Shop login(Shop shop) {
       return shopRepo.login(shop);

    }

    @Override
    public List<Shop> getShops() {
        return shopRepo.allShops();
    }


}
