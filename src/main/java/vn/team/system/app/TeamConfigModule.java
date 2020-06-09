package vn.team.system.app;

import java.sql.Connection;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import vn.team.system.common.ModuleConfig;
import vn.team.system.common.constant.start.DatabaseConfig;

@Slf4j
@Configuration
@AllArgsConstructor
public class TeamConfigModule {

  private final ModuleConfig moduleConfig;

  @Bean
  public Connection initJooq() {
    try {
      DatabaseConfig input = moduleConfig.getDatabaseConfig();
      Connection con = getDataSource().getConnection();
      log.info("Init connection to db success");
      return con;
    } catch (Exception e) {
      throw new RuntimeException("Cant't init connection to db");
    }
  }

  @Bean
  public DataSource getDataSource() {
    DatabaseConfig dbConfig = moduleConfig.getDatabaseConfig();
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(dbConfig.getClassDriver());
    dataSource.setUrl(dbConfig.getUrl());
    dataSource.setUsername(dbConfig.getUsername());
    dataSource.setPassword(dbConfig.getPassword());
    return dataSource;
  }
}
