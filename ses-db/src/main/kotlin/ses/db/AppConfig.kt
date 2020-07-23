package ses.db

import io.micronaut.context.MessageSource
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.i18n.ResourceBundleMessageSource
import java.util.Locale

@Factory
class AppConfig {

    @Bean
    fun messageSource(): MessageSource {
        return ResourceBundleMessageSource("i18n.Messages", Locale.JAPAN)
    }
}
