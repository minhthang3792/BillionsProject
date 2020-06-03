package vn.team.system.repository.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import vn.team.system.common.context.AutoCloseableDSLContext;
import vn.team.system.common.info.UserInfo;
import vn.team.system.repository.BaseRepoImpl;
import vn.team.system.repository.intface.UserRepo;
import vn.team.system.repository.model.tables.User;
import vn.team.system.repository.model.tables.records.UserRecord;

@Repository
public class UserRepoImpl extends BaseRepoImpl<String, UserRecord, User> implements UserRepo {

  public List<UserInfo> getAll() {
    try (AutoCloseableDSLContext context = getAutoCloseableDSLContext()) {
      User user = User.USER;
      return context.selectFrom(user).fetchInto(UserInfo.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
