package param.test.controller.request;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.QueryValue;

import java.util.Optional;

@Introspected
public class QueryParamReq {
    @QueryValue("first_name")
    private Optional<String> firstName;
    @QueryValue("last_name")
    private Optional<String> lastName;

    public QueryParamReq(Optional<String> firstName, Optional<String> lastName) {
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
