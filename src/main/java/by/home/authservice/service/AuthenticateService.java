package by.home.authservice.service;

import by.home.authservice.util.CredentialsUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

    public AuthenticateService(UserService userService, AuthAppsService authAppsService) {
        this.userService = userService;
        this.authAppsService = authAppsService;
    }

    private final UserService userService;

    private final AuthAppsService authAppsService;

    public AuthAppsService.AppCredentials authorizeApp(String authHeader, String appId) {
        var credentials = CredentialsUtil.restoreCredentials(authHeader);
        var userId = userService.getUserId(credentials.login(), credentials.password());
        return authAppsService.authorizeApp(appId, userId);
    }

}
