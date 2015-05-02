package net.evdokimov.eshopSpring.repository.springdatajpa;



import net.evdokimov.eshopSpring.model.ProductType;
import net.evdokimov.eshopSpring.repository.ProductTypeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SpringDataProductTypeRepository extends ProductTypeRepository, JpaRepository<ProductType, Integer> {
}
