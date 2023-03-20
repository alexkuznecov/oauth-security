package by.home.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/authorize")
public class AuthorizeController {

    @GetMapping("/token")
    public String authorize(@RequestParam String clientId,
                            @RequestParam String clientSecret,
                            @RequestParam String grantType,
                            @RequestParam String authCode) {
        return "";
    }

}
