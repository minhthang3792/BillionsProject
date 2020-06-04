package vn.team.system;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import vn.team.system.common.ObjectHelper;
import vn.team.system.common.info.UserInfo;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class App {

  private static final Logger log = LogManager.getLogger(App.class.getName());

  public static void main(String args[]) {
    SpringApplication.run(App.class, args);
  }
}
