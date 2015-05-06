package net.evdokimov.eshopSpring.service;


import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.model.ProductType;
import net.evdokimov.eshopSpring.model.User;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EshopService {

    Product findProductById(int id) throws DataAccessException;

    List<Product> findProductByTypeId(int type_id) throws DataAccessException;

    List<Product> findProducts() throws DataAccessException;

    void saveProduct(Product product) throws DataAccessException;

    void deleteProduct(int id) throws DataAccessException;

    List<ProductType> findTypes() throws DataAccessException;

    User saveUser(User user) throws DataAccessException;

    User findUserByLoginAndPassword(String login, String password);


}
