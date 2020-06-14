package vn.team.system.repository.intface;

import java.util.List;
import org.springframework.stereotype.Component;
import vn.team.system.common.info.UserInfo;

@Component
public interface UserRepo {

  List<UserInfo> getAll();
}
