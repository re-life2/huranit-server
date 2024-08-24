package relife.huranit.global.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckApiController {
    @RequestMapping("/")
    public String HuranitServer() {
        return "Hello Huranit Server!";
    }


    @RequestMapping("/example")
    public ResponseEntity<SuccessResponse<?>> example() {
        return SuccessResponse.ok("example");
    }
}