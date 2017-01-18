# log-aop

# 使用示例

```java
@Service
@Comment("方法模块注释")
public class AServiceImpl implements AService {

    private static final Logger log = LoggerFactory.getLogger(AServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Comment("业务方法注释")
    public String methodB(String a, Integer b, int c, Date date) {
        log.info("业务逻辑执行...");
        return "我是返回值";
    }
}
```

# 日志效果：
```
23:34:30.069 [main] INFO  com.alibaba.druid.pool.DruidDataSource {dataSource-1} inited

23:34:30.332 [main] INFO  com.junbaor.aop.aspect.LogAspect 方法模块注释-业务方法注释 方法调用--> com.junbaor.aop.service.impl.AServiceImpl#methodB 参数:["aop",1,2,"2017-01-18 23:34:30"]

23:34:30.337 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager Creating new transaction with name [com.junbaor.aop.service.impl.AServiceImpl.methodB]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT,-java.lang.Exception
23:34:30.340 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager Acquired Connection [com.mysql.jdbc.JDBC4Connection@19593091] for JDBC transaction
23:34:30.343 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager Switching JDBC Connection [com.mysql.jdbc.JDBC4Connection@19593091] to manual commit
23:34:30.354 [main] INFO  com.junbaor.aop.service.impl.AServiceImpl 业务逻辑执行...
23:34:30.354 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager Initiating transaction commit
23:34:30.354 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager Committing JDBC transaction on Connection [com.mysql.jdbc.JDBC4Connection@19593091]
23:34:30.355 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager Releasing JDBC Connection [com.mysql.jdbc.JDBC4Connection@19593091] after transaction

23:34:30.356 [main] INFO  com.junbaor.aop.aspect.LogAspect 调用结束<-- com.junbaor.aop.service.impl.AServiceImpl#methodB 参数:["aop",1,2,"2017-01-18 23:34:30"] 返回值:"我是返回值"
```
