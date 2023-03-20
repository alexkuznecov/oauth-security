package by.home.authservice.repository;

import by.home.authservice.model.AuthApps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthAppsRepository extends CrudRepository<AuthApps, Long> {

    Optional<AuthApps> findByAppCodeAndUserId(String appCode, Long userId);

}
