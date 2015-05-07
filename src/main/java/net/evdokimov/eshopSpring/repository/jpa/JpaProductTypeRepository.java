package net.evdokimov.eshopSpring.repository.jpa;

import net.evdokimov.eshopSpring.model.ProductType;
import net.evdokimov.eshopSpring.repository.ProductTypeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class JpaProductTypeRepository implements ProductTypeRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductType> findAll() {
        return (List<ProductType>)em.createQuery("SELECT pt FROM ProductType pt").getResultList();
    }

    @Override
    public ProductType findByType(String type) {
        return (ProductType)em.createQuery("SELECT pt FROM ProductType pt WHERE pt.type=:type")
                .setParameter("type", type)
                .getSingleResult();
    }
}
