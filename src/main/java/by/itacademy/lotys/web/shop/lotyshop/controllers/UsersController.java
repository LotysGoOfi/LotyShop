package by.itacademy.lotys.web.shop.lotyshop.controllers;

import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.users.UserResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.services.users.UserService;
import by.itacademy.lotys.web.shop.lotyshop.transformers.users.UserTransformers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final UserTransformers userTransformers;

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserResponse> getAll(@SortDefault(sort = "name", direction = Sort.Direction.ASC)
                                             Pageable pageable) {
        return userTransformers.getResponses(
                userService.findAll(pageable).getContent());
    }

    @GetMapping("id={id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse get(@PathVariable UUID id) {
        return userTransformers.getResponse(userService.findById(id));
    }

    @GetMapping("email={email}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse getUser(@PathVariable String email) {
        return userTransformers.getResponse(
                userService.findByEmail(email));
    }

    @GetMapping("user_role={userRole}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserResponse> getUser(@PathVariable UserRole userRole,
                                      @SortDefault(sort = "name",
                                              direction = Sort.Direction.ASC)
                                              Pageable pageable) {
        return userTransformers.getResponses(
                userService.findByRole(userRole, pageable));
    }

    @PutMapping("id={id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse update(@Valid @RequestBody UserRequest request,
                               @PathVariable UUID id) {
        User entity = userTransformers.getEntity(request);
        entity.setId(id);
        return userTransformers.getResponse(
                userService.update(entity));
    }

    @PostMapping("create")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse create(@Valid @RequestBody UserRequest request) {
        User entity = userTransformers.getEntity(request);
        return userTransformers.getResponse(
                userService.create(entity));
    }

    @DeleteMapping("id={id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserResponse delete(@PathVariable UUID id) {
        return userTransformers.getResponse(userService.delete(id));
    }

}