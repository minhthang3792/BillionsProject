package vn.team.system.common;

import lombok.Data;
import lombok.experimental.Accessors;
import vn.team.system.common.constant.start.DatabaseConfig;

@Data
@Accessors(chain = true)
public class ModuleConfig {

  private DatabaseConfig databaseConfig;
}
