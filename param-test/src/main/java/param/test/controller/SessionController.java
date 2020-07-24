package param.test.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.CookieValue;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.session.Session;
import io.micronaut.session.annotation.SessionValue;
import io.micronaut.validation.Validated;

import java.util.Optional;

@Controller("/session")
@Validated
public class SessionController {
    @Post(value = "/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public String setName(Session session, @Body Optional<String> name) {
        if (name.isPresent())
            session.put("name", name.get());
        return name.orElse("Hi!");
    }

    @Get("/hello")
    public String hello(Session session) {
        return session.get("name", String.class).orElse("Hi!");
    }

    @Get("/hello2")
    @SessionValue("name")
    public String hello2(@SessionValue Optional<String> name) {
        return name.orElse("Hi!");
    }

}
