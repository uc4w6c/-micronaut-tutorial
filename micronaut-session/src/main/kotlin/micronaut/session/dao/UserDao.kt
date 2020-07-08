package micronaut.session.dao

import micronaut.session.dao.config.DaoConfig
import micronaut.session.domain.User
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.Sql

@Dao
@DaoConfig
interface UserDao {
    @Select
    @Sql("select user_id, password from users where user_id = /* userName */'test'")
    fun findUser(userName: String): User
}
