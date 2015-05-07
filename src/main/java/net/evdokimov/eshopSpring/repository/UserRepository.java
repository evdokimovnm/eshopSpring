package net.evdokimov.eshopSpring.repository;


import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.repository.exceptions.LoginExistException;
import net.evdokimov.eshopSpring.repository.exceptions.NotSuchElementException;

public interface UserRepository {

    User findByLoginAndPassword(String login, String password) throws NotSuchElementException;

    User saveAndFlush(User user) throws LoginExistException;
}
