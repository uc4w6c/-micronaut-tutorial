package micronaut.session

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationException
import io.micronaut.security.authentication.AuthenticationFailed
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import micronaut.session.service.PasswordEncoderService
import micronaut.session.service.UserService
import org.reactivestreams.Publisher

import javax.inject.Singleton
import java.util.ArrayList

@Singleton
class AuthenticationProviderUserPassword(
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoderService
) : AuthenticationProvider{

    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>): Publisher<AuthenticationResponse> {
        return Flowable.create<AuthenticationResponse>({ emitter ->
            val user = userService.getUser(authenticationRequest.getIdentity().toString());
            // if (authenticationRequest.getIdentity().equals("sherlock") && authenticationRequest.getSecret().equals("password")) {
            val rawPassword = authenticationRequest.getSecret().toString()
            if (user.equals(passwordEncoder.encode(rawPassword))) {
                // val userDetails = UserDetails(authenticationRequest.getIdentity() as String, ArrayList<String>())
                val userDetails = UserDetails(user.userName, ArrayList<String>())
                emitter.onNext(userDetails)
                emitter.onComplete()
            } else {
                emitter.onError(AuthenticationException(AuthenticationFailed()))
            }

        }, BackpressureStrategy.ERROR)
    }
}
