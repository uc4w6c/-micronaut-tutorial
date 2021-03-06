package micronaut.session.dao.config

import org.seasar.doma.jdbc.tx.TransactionManager
import org.seasar.doma.jdbc.dialect.Dialect
import org.seasar.doma.jdbc.dialect.H2Dialect
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource
import org.seasar.doma.jdbc.Config
import javax.inject.Singleton
import javax.sql.DataSource

@Singleton
class DomaConfig(
    private val dataSource: LocalTransactionDataSource,
    private val transactionManager: LocalTransactionManager
) : Config {

    override fun getDialect(): Dialect = H2Dialect()

    override fun getDataSource(): DataSource {
        return dataSource
    }

    override fun getTransactionManager(): TransactionManager {
        return transactionManager
    }
}
