package net.evdokimov.eshopSpring.repository.jpa;

import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.repository.ProductRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class JpaProductRepository implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findByTypeId(int type_id) {
        return  (List<Product>)em.createQuery("SELECT p FROM Product p WHERE p.type.id=:type_id")
                .setParameter("type_id", type_id)
                .getResultList();
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product AS p").getResultList();
    }

    @Override
    public Product saveAndFlush(Product product) {
        if (product.getId() == null) {
            this.em.persist(product);
            return product;
        }
        else {
            return this.em.merge(product);
        }
    }

    @Override
    public void deleteById(int id) {
        em.remove(em.find(Product.class, id));
    }
}
