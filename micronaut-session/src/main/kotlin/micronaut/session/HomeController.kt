package micronaut.session

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.views.View
import java.security.Principal
import java.util.HashMap

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller
class HomeController {

    @Produces(MediaType.TEXT_HTML)
    @Get
    @View("home")
    internal fun index(principal: Principal?): Map<String, Any> {
        val data = HashMap<String, Any>()
        data["loggedIn"] = principal != null
        if (principal != null) {
            data["username"] = principal.name
        }
        return data
    }
}
