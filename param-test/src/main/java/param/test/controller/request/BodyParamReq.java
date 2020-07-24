package param.test.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.util.Optional;

@Introspected
public class BodyParamReq {
    @JsonProperty("first_name")
    private Optional<String> firstName;
    @JsonProperty("last_name")
    private Optional<String> lastName;

    public BodyParamReq(Optional<String> firstName, Optional<String> lastName) {
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
