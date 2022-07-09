package by.itacademy.lotys.web.shop.lotyshop.dtos.user;

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

    @NotBlank
    private UUID id;

    @NotBlank
    private UserRole userRole;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String login;

}