package by.home.authservice.controller;

import by.home.authservice.service.AuthenticateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/authenticate")
public class AuthenticateController {

    private final AuthenticateService authenticateService;

    public AuthenticateController(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @GetMapping("/app/{appId}")
    public AuthorizeResponse authorizeApp(@RequestHeader String authorization, @PathVariable String appId) {
        var appInfo = authenticateService.authorizeApp(authorization, appId);
        return new AuthorizeResponse(appInfo.code(), appInfo.secret());
    }

    public record AuthorizeResponse(String code, String secret) {     }
}
