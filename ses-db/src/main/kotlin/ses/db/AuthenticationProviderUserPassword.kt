package ses.db

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.*
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import micronaut.session.dao.config.Transactional
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
