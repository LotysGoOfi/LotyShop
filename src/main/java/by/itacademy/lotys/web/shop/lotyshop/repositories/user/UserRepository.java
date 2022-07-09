package by.itacademy.lotys.web.shop.lotyshop.repositories.user;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "select user from User user where user.email = :email")
    User getUsersByEmail(String email);

    @Query(value = "select user from User user where user.userRole = :userRole")
    List<User> getUsersBy(UserRole userRole);

}