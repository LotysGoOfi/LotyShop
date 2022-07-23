package by.itacademy.lotys.web.shop.lotyshop.transformers.users;

import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserRequest;

import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.transformers.Transformers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class UserTransformers implements Transformers<UserRequest,UserResponse,User> {

    @Override
    public User getEntity(UserRequest userRequest){
        return User.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .role(UserRole.USER)
                .password(userRequest.getPassword()).build();
    }

    @Override
    public UserResponse getResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userRole(user.getRole())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    @Override
    public List<UserResponse> getResponses(List<User> users){
        return users.stream()
                .map(this::getResponse)
                .collect(Collectors.toList());
    }

}
