package vn.team.system.repository.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Record1;
import org.jooq.SelectJoinStep;
import org.springframework.stereotype.Repository;
import vn.team.system.common.context.AutoCloseableDSLContext;
import vn.team.system.common.exception.DBException;
import vn.team.system.common.info.DepartInfo;
import vn.team.system.repository.BaseRepoImpl;
import vn.team.system.repository.intface.UserRepo;
import vn.team.system.repository.model.tables.Depart;
import vn.team.system.repository.model.tables.User;
import vn.team.system.repository.model.tables.records.UserRecord;

@Repository
@Slf4j
public class UserRepoImpl extends BaseRepoImpl<String, UserRecord, User> implements UserRepo {

  @Override
  public List<DepartInfo> getAll() {
    try (AutoCloseableDSLContext context = getAutoCloseableDSLContext()) {
      Depart depart = Depart.DEPART;
      SelectJoinStep sql = context
          .select(depart.ID)
          .from(depart);
      System.out.println(sql.toString());
      return sql
          .fetchInto(DepartInfo.class);
    } catch (Exception e) {
      log.error("get context error: {}", e.getMessage());
      throw new DBException.SQLError("get context error");
    }
  }
}
