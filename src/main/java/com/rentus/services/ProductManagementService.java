package com.rentus.services;


/*//import com.rentus.models.Jacket;
import com.rentus.models.JacketType;
import com.rentus.models.Shoe;
import com.rentus.models.Tent;
import com.rentus.models.TentType;*/
import com.rentus.models.Product;
import com.rentus.repository.ProductRepository;
import com.rentus.utility.RepoFactory;

import javax.transaction.Transactional;
import java.util.List;


public class ProductManagementService implements ProductService {
private ProductRepository toolRepo;
public ProductManagementService(){
    this.toolRepo = RepoFactory.getProductRepo();

}
    @Transactional
    @Override
    public List<Product> getProducts() {
        return toolRepo.allProducts();
    }

    @Override
    public List<Product> getBookedProducts() {
        return toolRepo.getAllBookedProducts();
    }

    @Override
    public boolean update(Product product) {
        return  RepoFactory.getProductRepo().update(product);
    }

    /*@Override
    public void orderTool(Tool tool) {
        toolRepo.

    }*/

    @Override
    public void create(Product product) {
        product.setBooked(false);
        toolRepo.create(product);
    }

    @Override
    public Product findById(int id) {
        return (Product) toolRepo.getById(id);
    }

    @Override
    public List<Product> findByCategories(String type) {
        return toolRepo.getByCategories(type);
    }

    @Override
    public void delete(Product product) {
        toolRepo.delete(product);
    }



    @Override
    public List<Product> ShopTools(int id) {
        return toolRepo.getShopTools(id);
    }
}





