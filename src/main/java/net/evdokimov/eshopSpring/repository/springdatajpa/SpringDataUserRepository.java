package net.evdokimov.eshopSpring.repository.springdatajpa;


import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends UserRepository, JpaRepository<User, Integer> {
}
