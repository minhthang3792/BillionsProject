package vn.team.system.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ModuleConfig {

  private DbConnection databaseConfig;
}
