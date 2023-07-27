package am.hitech.controller;

import am.hitech.model.User;
import am.hitech.model.dto.request.UserRequestDto;
import am.hitech.service.UserService;
import am.hitech.util.exception.DuplicateException;
import am.hitech.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getById(@RequestParam int id) throws NotFoundException {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserRequestDto requestDto) throws DuplicateException {

        userService.create(requestDto);
        return ResponseEntity.ok().build();
    }
}
