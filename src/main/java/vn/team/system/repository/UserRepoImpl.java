package vn.team.system.repository;

import java.sql.Connection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import vn.team.system.common.context.AutoCloseableDSLContext;
import vn.team.system.common.info.UserInfo;
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
