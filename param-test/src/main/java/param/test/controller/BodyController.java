package param.test.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.RequestAttribute;
import io.micronaut.http.annotation.RequestAttributes;
import io.micronaut.validation.Validated;
import param.test.controller.request.BodyParamReq;

import java.util.Optional;

@Controller("/body")
@Validated
public class BodyController {
    @Post(value = "/hello", consumes = MediaType.TEXT_PLAIN)
    public String hello(@Body Optional<String> name) {
        return name.orElse("Hi!");
    }

    @Post("/hello2")
    public String hello2(@Body BodyParamReq bodyParamReq) {
        return bodyParamReq.getFirstName().orElse("sei") + " " +
               bodyParamReq.getLastName().orElse("mei") + " さん";
    }

    @Post(value = "/hello3", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    public String hello3(@Body("first_name") Optional<String> firstName, @Body("last_name") Optional<String> lastName) {
        return firstName.orElse("sei") + " " +
                lastName.orElse("mei") + " さん";
    }
}
