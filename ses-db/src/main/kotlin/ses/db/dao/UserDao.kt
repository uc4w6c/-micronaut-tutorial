package ses.db.dao.config

import micronaut.session.dao.config.DaoConfig
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.Sql
import ses.db.entity.UserEntity

@Dao
@DaoConfig
interface UserDao {
    @Select
    @Sql("select user_id, password from users where user_id = /* userName */'test'")
    fun findUser(userName: String): UserEntity
}
