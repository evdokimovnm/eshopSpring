package net.evdokimov.eshopSpring.service;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.model.ProductType;
import org.hibernate.validator.internal.util.logging.Log;
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
        int productType = types.indexOf(new ProductType("Animals"));
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
}
