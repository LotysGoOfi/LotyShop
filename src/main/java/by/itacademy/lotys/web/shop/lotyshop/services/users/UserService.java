package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.services.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.UUID;


public interface UserService extends ServiceEntity<User,UUID> {
    User getUserByEmail(String email);
    Page<User> getAll(Pageable pageable);
    List<User> getUsersBuRole(UserRole userRole, Pageable pageable);
}
