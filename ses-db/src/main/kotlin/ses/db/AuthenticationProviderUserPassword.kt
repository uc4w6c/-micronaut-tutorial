package ses.db

import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.micronaut.security.authentication.AuthenticationException
import io.micronaut.security.authentication.AuthenticationFailed
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.micronaut.http.HttpRequest
import org.reactivestreams.Publisher
import ses.db.service.PasswordEncoderService
import ses.db.service.UserService
import java.util.ArrayList
import javax.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword(
        private val userService: UserService,
        private val passwordEncoder: PasswordEncoderService
) : AuthenticationProvider {

    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {
        return Flowable.create<AuthenticationResponse>({ emitter ->
            val user = userService.getUser(authenticationRequest.getIdentity().toString());
            val rawPassword = authenticationRequest.getSecret().toString()
            if (user.userId.equals(passwordEncoder.encode(rawPassword))) {
                val userDetails = UserDetails(user.userId, ArrayList<String>())
                emitter.onNext(userDetails)
                emitter.onComplete()
            } else {
                emitter.onError(AuthenticationException(AuthenticationFailed()))
            }

        }, BackpressureStrategy.ERROR)
    }
}
