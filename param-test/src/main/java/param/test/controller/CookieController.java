package param.test.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.CookieValue;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.RequestBean;
import io.micronaut.validation.Validated;
import param.test.controller.request.QueryParamReq;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Controller("/cookie")
@Validated
public class CookieController {
    @Get("/hello")
    public String hello(@CookieValue("name") Optional<String> name) {
        return name.orElse("Hi!");
    }
}
