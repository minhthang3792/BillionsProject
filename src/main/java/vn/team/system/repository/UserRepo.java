package vn.team.system.repository;

import java.util.List;
import vn.team.system.common.info.UserInfo;

public interface UserRepo {

  List<UserInfo> getAll();
}
