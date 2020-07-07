package micronaut.session.domain

import org.seasar.doma.Column
import org.seasar.doma.Entity
import org.seasar.doma.Id
import org.seasar.doma.Table
import org.seasar.doma.jdbc.entity.NamingType

@Entity(immutable = true, naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "users")
data class User(
    @Id
    val userName: String,
    val password: String
)
