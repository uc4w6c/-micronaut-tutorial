package param.test.controller.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.QueryValue;

@Introspected
public class HelloRequest {
    @QueryValue("first_name")
    private String firstName;
    @QueryValue("last_name")
    private String lastName;

    public HelloRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
