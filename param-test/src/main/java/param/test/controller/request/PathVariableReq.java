package param.test.controller.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;

import java.util.Optional;

@Introspected
public class PathVariableReq {
    @PathVariable("first_name")
    private Optional<String> firstName;
    @PathVariable("last_name")
    private Optional<String> lastName;

    public PathVariableReq(Optional<String> firstName, Optional<String> lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Optional<String> getFirstName() {
        return this.firstName;
    }

    public Optional<String> getLastName() {
        return this.lastName;
    }
}
