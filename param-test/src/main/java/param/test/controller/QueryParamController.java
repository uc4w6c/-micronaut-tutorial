package param.test.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.RequestBean;
import io.micronaut.validation.Validated;
import param.test.controller.request.HelloRequest;
import param.test.controller.response.HelloResponse;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller("/queryparam")
@Validated
public class QueryParamController {
    @Get("/hello{?name}")
    // @Get("/value") // パラメータ名の省略も可能
    public String hello(Optional<String> name) {
        return name.orElse("Hi!");
    }

    @Get("/hello2{?first_name}")
    public String hello2(@QueryValue("first_name") Optional<String> firstName) {
        return firstName.orElse("Hi!");
    }

    @Get("/hello3")
    public String hello3(@NotBlank String name) {
        return name;
    }
}
