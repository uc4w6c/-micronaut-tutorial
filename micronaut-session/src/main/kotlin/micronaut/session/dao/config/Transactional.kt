package micronaut.session.dao.config

import io.micronaut.aop.Around
import io.micronaut.context.annotation.Type
import java.lang.annotation.ElementType
import java.lang.annotation.Documented


@Documented
@Retention(AnnotationRetention.RUNTIME)
// @Target(ElementType.TYPE, ElementType.METHOD)
@Target(AnnotationTarget.PROPERTY)
@Around
@Type(TransactionInterceptor::class)
annotation class Transactional
