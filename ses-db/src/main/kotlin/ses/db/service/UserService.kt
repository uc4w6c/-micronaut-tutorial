package ses.db.service

import micronaut.session.dao.config.Transactional
import ses.db.dao.config.UserDao
import ses.db.entity.UserEntity
import javax.inject.Singleton

@Singleton
@Transactional
class UserService(private val userDao: UserDao) {
    fun getUser(userName: String): UserEntity {
        return userDao.findUser(userName)
    }
}
