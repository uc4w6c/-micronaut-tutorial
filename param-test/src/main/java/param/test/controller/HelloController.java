package param.test.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import param.test.controller.response.HelloResponse;

@Controller("/hello")
public class HelloController {
    @Get("/")
    public HelloResponse index() {
        return new HelloResponse("taro", "東京都千代田区");
    }
}
