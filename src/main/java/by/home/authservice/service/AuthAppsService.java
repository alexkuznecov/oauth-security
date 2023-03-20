package by.home.authservice.service;

import by.home.authservice.model.AuthApps;
import by.home.authservice.repository.AuthAppsRepository;
import by.home.authservice.util.Generator;
import org.springframework.stereotype.Service;

@Service
public class AuthAppsService {

    private final AuthAppsRepository appsRepository;

    public AuthAppsService(AuthAppsRepository appsRepository) {
        this.appsRepository = appsRepository;
    }

    public AppCredentials authorizeApp(String appCode, Long userId) {
        appsRepository.findByAppCodeAndUserId(appCode, userId)
                .ifPresent(appsRepository::delete);
        var appInfo = new AuthApps();
        appInfo.setUserId(userId);
        appInfo.setAppId(appCode);

        var appCredentials = new AppCredentials(Generator.generateAppCode(), Generator.generateAppSecret());

        appInfo.setAppCode(appCredentials.code);
        appInfo.setAppSecret(appCredentials.secret);

        appsRepository.save(appInfo);

        return appCredentials;
    }

    public record AppCredentials(String code, String secret) {}
}
