package micronaut.session.service

import micronaut.session.domain.Book
import javax.inject.Singleton

@Singleton
class TestService {
    fun excute(): Book {
        return Book(1);
    }
}
