package vn.team.system;

import com.google.gson.Gson;
import java.io.File;
import java.nio.file.Files;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import vn.team.system.common.ModuleConfig;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class App {

  public static void main(String args[]) {
    SpringApplication.run(App.class, args);
  }

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
}
