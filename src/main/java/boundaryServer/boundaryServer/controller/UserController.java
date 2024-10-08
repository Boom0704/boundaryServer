package boundaryServer.boundaryServer.controller;

import boundaryServer.boundaryServer.model.User;
import boundaryServer.boundaryServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")  // 경로 prefix 설정
public class UserController {
    final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 로그인 (단순 조회 테스트용)
    @PostMapping("/login")
    public String loginDo(@RequestParam String username) {
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            return "User found: " + user.get().getUsername();
        }
        return "User not found";
    }

    // 유저 등록 (회원가입)
    @PostMapping("/signup")
    public String registerUser(@RequestBody User user) {
        if (userService.isUserExists(user.getUsername())) {
            return "Username already exists!";
        }
        User newUser =userService.registerUser(user);
        return "User registered: " + newUser.getUsername();
    }

    // ID로 유저 조회
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // ID로 유저 조회
    @GetMapping("/{id}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // 유저 전부 가져오기
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
