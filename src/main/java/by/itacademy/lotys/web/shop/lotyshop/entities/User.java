package by.itacademy.lotys.web.shop.lotyshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private int id;
    private String UserRole;
    private String email;
    private String nickName;
    private String password;
}