package net.evdokimov.eshopSpring.repository;

import net.evdokimov.eshopSpring.model.ProductType;
import java.util.List;

public interface ProductTypeRepository {

    List<ProductType> findAll();

    ProductType findByType(String type);
}
