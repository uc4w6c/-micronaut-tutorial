package micronaut.session.dao.config

import io.micronaut.aop.MethodInvocationContext
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import io.micronaut.aop.MethodInterceptor
import java.util.function.Supplier
import javax.inject.Singleton

@Singleton
class TransactionInterceptor(private val transactionManager: LocalTransactionManager) : MethodInterceptor<Any?, Any?> {
    override fun intercept(context: MethodInvocationContext<Any?, Any?>): Any? {
        return transactionManager.required(Supplier { context.proceed() })
    }
}
