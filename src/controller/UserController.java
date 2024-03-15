package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import entity.User;
import service.UserService;
import java.sql.SQLException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) throws SQLException {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws SQLException {
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) throws SQLException {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable String id, @RequestBody User updatedUser) throws SQLException {
        userService.updateUser(id, updatedUser);
        return ResponseEntity.noContent().build();
    }
}
