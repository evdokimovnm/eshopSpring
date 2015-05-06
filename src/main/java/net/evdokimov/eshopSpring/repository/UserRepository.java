package net.evdokimov.eshopSpring.repository;


import net.evdokimov.eshopSpring.model.User;

public interface UserRepository {

    User findByLoginAndPassword(String login, String password);

    User saveAndFlush(User user);
}
