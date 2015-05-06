package net.evdokimov.eshopSpring.repository.jpa;

import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.repository.UserRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public User findByLoginAndPassword(String login, String password) {
        return (User)em.createQuery("SELECT u FROM User u WHERE u.login=:login AND u.password=:password")
                .setParameter("login", login)
                .setParameter("password", password)
                .getSingleResult();
    }

    @Override
    public User saveAndFlush(User user) {
        if(user.getId() == null) {
            this.em.persist(user);
            return user;
        } else {
            return this.em.merge(user);
        }
    }
}
