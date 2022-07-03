package by.itacademy.lotys.web.shop.lotyshop.transformers.user;

import by.itacademy.lotys.web.shop.lotyshop.dtos.user.UserRequest;

import by.itacademy.lotys.web.shop.lotyshop.dtos.user.UserResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.transformers.Transformers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformers implements Transformers<UserRequest,UserResponse,User> {

    @Override
    public User getEntity(UserRequest userRequest){
        return User.builder()
                .email(userRequest.getEmail())
                .login(userRequest.getLogin())
                .userRole(UserRole.USER)
                .password(userRequest.getPassword()).build();
    }

    @Override
    public UserResponse getResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userRole(user.getUserRole())
                .login(user.getLogin())
                .email(user.getEmail())
                .password(user.getPassword()).build();
    }

    @Override
    public List<UserResponse> getResponses(List<User> users){
        return users.stream()
                .map(this::getResponse)
                .collect(Collectors.toList());
    }

}
