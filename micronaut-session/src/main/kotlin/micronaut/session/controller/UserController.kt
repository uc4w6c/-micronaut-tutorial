package micronaut.session.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.views.View
import micronaut.session.domain.User
import micronaut.session.service.UserService
import java.security.Principal
import java.util.HashMap

@Secured(SecurityRule.IS_ANONYMOUS)
// @Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/user")
class UserController(private val userService: UserService) {

    @Get("/")
    internal fun index(/*@Body name: String*/): User {
        return userService.getUser("test")
    }
}
