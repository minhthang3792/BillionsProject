package vn.team.system.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.team.system.common.ModuleConfig;
import vn.team.system.common.constant.start.DatabaseConfig;
import vn.team.system.common.context.ExceptionTranslator;
import vn.team.system.common.context.SpringConnectionProvider;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class TeamConfigModule {

  private final ModuleConfig moduleConfig;
  private HikariDataSource dataSource;

  @Bean
  public org.jooq.Configuration getConfiguration() {
    Settings settings = new Settings();
    settings.setExecuteLogging(false);

    return new DefaultConfiguration()
        .set(new SpringConnectionProvider(dataSource))
        .set(
            SQLDialect.MYSQL) //TODO need a factory to produce dialect according to dataSourceClassName
        .set(new DefaultExecuteListenerProvider(new ExceptionTranslator(dataSource)))
        .set(settings)
        ;
  }

  @Bean
  public Connection getConnection() throws SQLException {
    return initJooq(moduleConfig).getConnection();
  }

  @Bean
  public DataSource initJooq(ModuleConfig moduleConfig) {
    DatabaseConfig config = moduleConfig.getDatabaseConfig();

    //config hikariCp by above attributes
    HikariConfig hikariConfig = new HikariConfig();
//    hikariConfig.setDataSourceClassName(config.getClassDriver());
    hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
    hikariConfig.setJdbcUrl(config.getUrl());
    hikariConfig.setUsername(config.getUsername());
    hikariConfig.setPassword(config.getPassword());
//    hikariConfig.addDataSourceProperty("serverName", "localhost");
//    hikariConfig.addDataSourceProperty("portNumber", 3306);
//    hikariConfig.addDataSourceProperty("databaseName", config.getDatabase());
    hikariConfig.setConnectionTimeout(10000);
    hikariConfig
        .setAutoCommit(true); //disable this one because we will use our own TransactionalManager
    log.info("Init connection to db success");
    dataSource = new HikariDataSource(hikariConfig);
    return dataSource;
  }

//  @Bean
//  public DataSource getDataSource() {
//    DatabaseConfig dbConfig = moduleConfig.getDatabaseConfig();
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(dbConfig.getClassDriver());
//    dataSource.setUrl(dbConfig.getUrl());
//    dataSource.setUsername(dbConfig.getUsername());
//    dataSource.setPassword(dbConfig.getPassword());
//    return dataSource;
//  }
}
