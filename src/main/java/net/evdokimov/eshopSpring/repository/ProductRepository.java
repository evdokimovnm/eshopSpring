package net.evdokimov.eshopSpring.repository;


import net.evdokimov.eshopSpring.model.Product;



import java.util.List;

public interface ProductRepository {

    Product findById(int id);

    List<Product> findByTypeId(int type_id);

    List<Product> findAll();

    Product saveAndFlush(Product product);

    void deleteById(int id);
}
