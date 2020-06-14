package vn.team.system;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import vn.team.system.common.ModuleConfig;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class App {

  public static void main(String args[]) {
    SpringApplication.run(App.class, args);
  }

  @Bean
  public ModuleConfig loadConfig() {
    try {
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(getClass().getResourceAsStream("/team-system-config.json")));
      String readFile = "";
      while (bufferedReader.ready()) {
        readFile += bufferedReader.readLine();
      }
      ModuleConfig moduleConfig = new Gson().fromJson(readFile, ModuleConfig.class);
      bufferedReader.close();
      return moduleConfig;
    } catch (Exception e) {
      throw new RuntimeException("Cant load config file");
    }
  }
}
