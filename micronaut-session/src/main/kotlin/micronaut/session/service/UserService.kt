package micronaut.session.service

import micronaut.session.dao.UserDao
import micronaut.session.domain.User
import javax.inject.Singleton

@Singleton
class UserService(private val userDao: UserDao) {
    fun getUser(userName: String): User {
        return userDao.findUser(userName)
    }
}
