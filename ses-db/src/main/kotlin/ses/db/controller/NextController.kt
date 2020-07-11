package ses.db.controller

import io.micronaut.context.MessageSource
import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import io.micronaut.views.View
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.ConstraintViolationException
import io.micronaut.http.annotation.Error
import java.util.*


@Secured(SecurityRule.IS_AUTHENTICATED)
@Validated
@Controller("/next")
class NextController(private val messageSource: MessageSource) {

    @Produces(MediaType.TEXT_HTML)
    @Get("/")
    @View("next")
    fun index(@QueryValue @Valid @NotBlank message: String): Map<String, Any> {
        return mapOf("message" to message)
    }

    @View("next")
    @Error(exception = ConstraintViolationException::class)
    fun initFailed(request: HttpRequest<Map<String, Any>>,
                   ex: ConstraintViolationException): Map<String, Any> {

        ex.constraintViolations.forEach { constraintViolation ->
            print(constraintViolation.message)
            print(" : ")
            print(messageSource.getMessage(constraintViolation.messageTemplate,
                    MessageSource.MessageContext.DEFAULT)
                    .orElse(constraintViolation.message))
            print(" : ")
            print(constraintViolation.messageTemplate)
            print(" : ")
            print(constraintViolation.propertyPath)
            println()
        }

        val responseMap = HashMap<String, Any>()
        responseMap["errors"] = ex.constraintViolations
                                    // .map { constraintViolation -> constraintViolation.message }
                                    .map { constraintViolation ->
                                        messageSource.getMessage(constraintViolation.messageTemplate,
                                                                    MessageSource.MessageContext.DEFAULT,
                                                                    // MessageSource.MessageContext.of(Locale("jp")),
                                                                    constraintViolation.message)
                                         // .orElse(constraintViolation.message)
                                    }.toList()
        // 以下は入力値をそのまま反映する処理
        // request.getBody(TaskForm::class.java).ifPresent({ form -> responseMap["taskForm"] = form })
        return responseMap
    }
}
