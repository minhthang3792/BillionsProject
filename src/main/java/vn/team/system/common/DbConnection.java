package vn.team.system.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DbConnection {

  private String url;
  private String username;
  private String password;
}
