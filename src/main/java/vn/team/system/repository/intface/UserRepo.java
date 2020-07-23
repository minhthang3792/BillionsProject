package vn.team.system.repository.intface;

import java.util.List;
import org.springframework.stereotype.Component;
import vn.team.system.common.info.DepartInfo;

@Component
public interface UserRepo {

  List<DepartInfo> getAll();
}
