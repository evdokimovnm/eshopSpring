package net.evdokimov.eshopSpring.service;


import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.model.ProductType;
import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.repository.exceptions.LoginExistException;
import net.evdokimov.eshopSpring.repository.exceptions.NotSuchElementException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public abstract class AbstractEshopServiceTest {

    @Autowired
    private EshopService eshopService;

    @Test
    public void shouldFindAllProducts() {
        List<Product> products = this.eshopService.findProducts();
        System.out.println(products);
    }

    @Test
    public void shouldFindProductById() {
        System.out.println(this.eshopService.findProductById(1));
    }


    @Test
    public void shouldFinedProductsByTypes() {
        List<Product> products = this.eshopService.findProductByTypeId(2);
        assertThat(products.size()).isEqualTo(1);
    }

    @Test
    public void shouldSaveProduct() {
        List<ProductType> types = this.eshopService.findTypes();
        int productType = types.indexOf(new ProductType("animals"));
        Product product = new Product();
        product.setName("dog");
        product.setType(types.get(productType));
        this.eshopService.saveProduct(product);
        assertThat(product.getId()).isNotEqualTo(0);
    }

    @Test
    public void shouldDeleteProduct() {
        eshopService.deleteProduct(1);
    }

    @Test
    public void shouldFinedAllTypes() {
        List<ProductType> types = this.eshopService.findTypes();
        assertThat(types.size()).isEqualTo(2);
    }

    @Test
    public void shouldSaveUser() throws LoginExistException {
        User userForSave = new User();
        userForSave.setLogin("Bred");
        userForSave.setEmail("bred@ya.ru");
        userForSave.setPassword("1234");
        User user = this.eshopService.saveUser(userForSave);
        System.out.println(user);
        assertThat(user.getId()).isNotEqualTo(0);
    }

    @Test
    public void shouldFinedUserByLoginAndEmail() throws NotSuchElementException {
        User user = this.eshopService.findUserByLoginAndPassword("Sara", "1234");
        assertThat(user.getId()).isEqualTo(2);
    }

}
