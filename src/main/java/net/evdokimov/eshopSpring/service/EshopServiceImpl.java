package net.evdokimov.eshopSpring.service;


import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.model.ProductType;
import net.evdokimov.eshopSpring.repository.ProductRepository;
import net.evdokimov.eshopSpring.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EshopServiceImpl implements EshopService{

    private ProductRepository productRepository;
    private ProductTypeRepository productTypeRepository;

    @Autowired
    public EshopServiceImpl(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(int id) throws DataAccessException {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductByTypeId(int type_id) throws DataAccessException{
        return productRepository.findByTypeId(type_id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProducts() throws DataAccessException{
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) throws DataAccessException{
        productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) throws DataAccessException{
        productRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductType> findTypes() throws DataAccessException{
        return productTypeRepository.findAll();
    }
}
