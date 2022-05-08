package by.itacademy.lotys.web.shop.lotyshop.entities;

import by.itacademy.lotys.web.shop.lotyshop.entities.enumes.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private int id;
    private UserRole userRole;
    private String email;
    private String nickName;
    private String password;
}