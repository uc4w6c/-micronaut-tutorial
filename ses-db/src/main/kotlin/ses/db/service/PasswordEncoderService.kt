package ses.db.service

import edu.umd.cs.findbugs.annotations.NonNull

import javax.validation.constraints.NotBlank

interface PasswordEncoderService {
    fun encode(@NotBlank @NonNull rawPassword: String): String
}
