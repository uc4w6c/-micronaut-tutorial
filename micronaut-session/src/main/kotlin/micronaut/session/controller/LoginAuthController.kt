package micronaut.session.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.views.View

import java.util.Collections
import java.util.HashMap

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/login")
public class LoginAuthController {

    @Produces(MediaType.TEXT_HTML)
    @Get("/auth")
    @View("auth")
    fun auth(): Map<String, Any> {
        return HashMap()
    }

    @Produces(MediaType.TEXT_HTML)
    @Get("/authFailed")
    @View("auth")
    fun authFailed(): Map<String, Any> {
        return Collections.singletonMap<String, Any>("errors", true)
    }
}
