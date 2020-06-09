package vn.team.system.repository;

import java.io.Serializable;
import java.util.List;
import org.jooq.Record;

public interface IBaseRepo<K extends Serializable, R extends Record> {

  List<R> fetchAll();

  void save(R record);

  void update(R record);
}
