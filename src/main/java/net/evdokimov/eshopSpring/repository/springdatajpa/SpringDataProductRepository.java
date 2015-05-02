package net.evdokimov.eshopSpring.repository.springdatajpa;


import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.repository.ProductRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface SpringDataProductRepository extends ProductRepository, JpaRepository<Product, Integer> {

}
