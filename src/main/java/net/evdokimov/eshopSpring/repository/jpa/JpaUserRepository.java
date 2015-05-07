package net.evdokimov.eshopSpring.repository.jpa;

import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.repository.UserRepository;
import net.evdokimov.eshopSpring.repository.exceptions.LoginExistException;
import net.evdokimov.eshopSpring.repository.exceptions.NotSuchElementException;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;



@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public User findByLoginAndPassword(String login, String password) throws NotSuchElementException {
        try {
            return (User)em.createQuery("SELECT u FROM User u WHERE u.login=:login AND u.password=:password")
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new NotSuchElementException("Not such login or password");
        }
    }

    @Override
    public User saveAndFlush(User user) throws LoginExistException {
        /*try {*/
            if(user.getId() == null) {
                this.em.persist(user);
                return user;
            } else {
                return this.em.merge(user);
            }
        /*} catch (Exception e) {
            throw new LoginExistException("Such login or email already exist");
        }*/
    }
}
