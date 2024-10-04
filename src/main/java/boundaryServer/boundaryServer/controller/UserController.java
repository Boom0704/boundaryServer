package boundaryServer.boundaryServer.controller;

import boundaryServer.boundaryServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserController(){
        UserService userService = new UserService();
    }

    @PostMapping("/login")
    public String loginDo() {
        String result = userService.getUser();
        return "loginDo";  // "test"라는 문자열을 HTTP 응답으로 반환
    }

    @PostMapping("/regist")
    public String rejistDo() {
        return "rejistDo";
    }
}
