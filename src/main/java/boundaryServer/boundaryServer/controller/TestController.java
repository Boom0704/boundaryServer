package boundaryServer.boundaryServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "test";  // "test"라는 문자열을 HTTP 응답으로 반환
    }
}
