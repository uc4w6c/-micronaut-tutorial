package param.test.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.RequestBean;
import io.micronaut.validation.Validated;
import param.test.controller.request.PathVariableReq;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Controller("/path")
// @Validated
public class PathController {
    @Get("/hello/{name}")
    public String hello(@PathVariable String name) {
        return name;
    }

    @Get("/hello2/{first_name}/{last_name}")
    public String hello2(@RequestBean PathVariableReq pathVariableReq) {
        return pathVariableReq.getFirstName().orElse("sei") + " " +
                pathVariableReq.getLastName().orElse("mei") + " さん";
    }

}
