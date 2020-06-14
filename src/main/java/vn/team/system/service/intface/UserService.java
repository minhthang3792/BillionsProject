package vn.team.system.service.intface;

import org.springframework.stereotype.Component;
import vn.team.system.common.info.RestfulCommonResponse;

@Component
public interface UserService {

  RestfulCommonResponse fetchAll();
}
