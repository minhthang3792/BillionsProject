package vn.team.system.common.exception;

public class DBException {

  public static class SQLExcuteError extends BaseException {

    public SQLExcuteError(String msg) {
      super(msg);
    }

    public SQLExcuteError(String msg, Throwable cause) {
      super(msg, cause);
    }
  }

  public static class SQLError extends BaseException {

    public SQLError(String msg) {
      super(msg);
    }

    public SQLError(String msg, Throwable cause) {
      super(msg, cause);
    }
  }
}
