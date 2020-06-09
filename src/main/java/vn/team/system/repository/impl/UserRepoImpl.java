package vn.team.system.repository.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import vn.team.system.common.context.AutoCloseableDSLContext;
import vn.team.system.common.exception.DBException;
import vn.team.system.common.info.UserInfo;
import vn.team.system.repository.BaseRepoImpl;
import vn.team.system.repository.intface.UserRepo;
import vn.team.system.repository.model.tables.User;
import vn.team.system.repository.model.tables.records.UserRecord;

@Repository
@Slf4j
public class UserRepoImpl extends BaseRepoImpl<String, UserRecord, User> implements UserRepo {

  @Override
  public List<UserInfo> getAll() {
    try (AutoCloseableDSLContext context = getAutoCloseableDSLContext()) {
      User user = User.USER;
      return context
          .selectFrom(user)
          .fetchInto(UserInfo.class);
    } catch (Exception e) {
      log.error("get context error: {}", e.getMessage());
      throw new DBException.SQLError("get context error");
    }
  }
}
