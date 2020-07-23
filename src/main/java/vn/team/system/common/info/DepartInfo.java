package vn.team.system.common.info;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DepartInfo {

  private String id;
  private String name;
}
