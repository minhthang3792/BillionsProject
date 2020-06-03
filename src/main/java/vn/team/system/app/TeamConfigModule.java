package vn.team.system.app;

import com.google.gson.Gson;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import vn.team.system.common.ModuleConfig;
import vn.team.system.common.constant.start.DatabaseConfig;

@Configuration
public class TeamConfigModule {

  @Bean
  public ModuleConfig loadConfig() {
    try {
      Resource resource = new ClassPathResource("team-system-config.json");
      File file = resource.getFile();
      String readFile = new String(Files.readAllBytes(file.toPath()));
      ModuleConfig moduleConfig = new Gson().fromJson(readFile, ModuleConfig.class);
      return moduleConfig;
    } catch (Exception e) {
      throw new RuntimeException("Cant load config file");
    }
  }

  @Bean
  public Connection initJooq() {
    try {
      Resource resource = new ClassPathResource("team-system-config.json");
      File file = resource.getFile();
      String readFile = new String(Files.readAllBytes(file.toPath()));
      ModuleConfig moduleConfig = new Gson().fromJson(readFile, ModuleConfig.class);
      DatabaseConfig input = moduleConfig.getDatabaseConfig();
      Connection con = DriverManager
          .getConnection(input.getUrl(), input.getUsername(), input.getPassword());
      return con;
    } catch (Exception e) {
      throw new RuntimeException("Cant't init connection to db");
    }
  }
}
