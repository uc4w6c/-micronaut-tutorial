package param.test.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.RequestBean;
import param.test.controller.request.HelloRequest;
import param.test.controller.response.HelloResponse;

import javax.annotation.Nullable;
import javax.validation.Valid;

@Controller("/hello")
public class HelloController {
    @Get("/")
    public HelloResponse index() {
        return new HelloResponse("taro", "東京都千代田区");
    }

    @Get("/queryparam1")
    public String queryParam1(@QueryValue("name") @Nullable String name) {
        return name;
    }


    @Get("/queryparam{?helloRequest*}")
    public HelloResponse queryParam2(@Valid @RequestBean HelloRequest helloRequest) {
        System.out.println(helloRequest.getFirstName() + " " + helloRequest.getLastName());
        return new HelloResponse("taro", "東京都千代田区");
    }
}
// http://localhost:8080/hello/queryparam?first_name=sato&last_name=taro
