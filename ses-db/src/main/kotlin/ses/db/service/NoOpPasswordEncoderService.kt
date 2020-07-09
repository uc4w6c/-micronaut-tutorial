package ses.db.service

import edu.umd.cs.findbugs.annotations.NonNull
// import org.springframework.security.crypto.password.NoOpPasswordEncoder
// import org.springframework.security.crypto.password.PasswordEncoder
import javax.inject.Singleton
import javax.validation.constraints.NotBlank

@Singleton
open class NoOpPasswordEncoderService(
        // private val delegate: PasswordEncoder = NoOpPasswordEncoder.getInstance()
): PasswordEncoderService {

    override fun encode(@NotBlank @NonNull rawPassword: String): String {
        // return delegate.encode(rawPassword)
        return rawPassword
    }
}
