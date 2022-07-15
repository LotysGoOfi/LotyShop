package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.services.ServiceEntity;

import java.util.List;
import java.util.UUID;


public interface UserService extends ServiceEntity<UserRequest,UserResponse,UUID> {
    UserResponse getUserByEmail(String email);
    List<UserResponse> getUsersBuRole(UserRole userRole);

}
