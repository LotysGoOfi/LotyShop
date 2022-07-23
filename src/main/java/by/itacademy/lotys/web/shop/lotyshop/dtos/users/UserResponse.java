package by.itacademy.lotys.web.shop.lotyshop.dtos.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private UUID id;

    private UserRole userRole;

    private String email;

    private String name;

}