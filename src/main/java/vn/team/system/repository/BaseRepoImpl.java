package vn.team.system.repository;

import java.io.Serializable;
import java.sql.Connection;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import vn.team.system.common.context.AutoCloseableDSLContext;

public class BaseRepoImpl<K extends Serializable, R extends Record, T extends Table> implements
    IBaseRepo<K, R> {

  @Autowired
  private Connection connection;

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

  protected AutoCloseableDSLContext getAutoCloseableDSLContext() throws Exception {
    return new AutoCloseableDSLContext(connection, SQLDialect.MYSQL);
  }

}
