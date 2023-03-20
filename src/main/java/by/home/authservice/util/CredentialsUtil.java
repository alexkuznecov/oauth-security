package by.home.authservice.util;

public class CredentialsUtil {

    public static Credentials restoreCredentials(String authHeaderValue) {
        var parsed = authHeaderValue.split(" ");
        if ("BASIC".equals(parsed[0])) {
            var creds = parsed[1].split(":");
            return new Credentials(creds[0], creds[1]);
        } else {
            throw new IllegalArgumentException("Auth type not supported");
        }
    }

    public record Credentials(String login , String password) {}

}
