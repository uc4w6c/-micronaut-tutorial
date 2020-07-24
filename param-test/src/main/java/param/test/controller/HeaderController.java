package param.test.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.CookieValue;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.validation.Validated;

import java.util.Optional;

@Controller("/header")
@Validated
public class HeaderController {
    @Get("/hello")
    public String hello(@Header("User-Agent") String userAgent) {
        return userAgent;
    }
}
