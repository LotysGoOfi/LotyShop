package by.itacademy.lotys.web.shop.lotyshop.controllers;

import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.services.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController{

    private final UserService userService;

    @GetMapping("id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse get(@PathVariable UUID id) {
        return userService.getByID(id);
    }

    @GetMapping("email/{email}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse getUser(@Valid @PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("all/{userRole}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserResponse> getAllUser(@PathVariable UserRole userRole) {
        return userService.getUsersBuRole(userRole);
    }

    @PutMapping("update/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse update(@Valid @RequestBody UserRequest request, @PathVariable UUID id) {
        return userService.update(request, id);
    }

    @GetMapping("create")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse create(@Valid @RequestBody UserRequest request) {
        return userService.create(request);
    }

    @GetMapping("delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse delete(@PathVariable UUID id) {
        return userService.delete(id);
    }

}
