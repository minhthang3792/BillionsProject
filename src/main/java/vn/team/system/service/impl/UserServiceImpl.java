package vn.team.system.service.impl;

import com.google.gson.Gson;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.team.system.common.constant.req_resp.CodeResponse;
import vn.team.system.common.info.DepartInfo;
import vn.team.system.common.info.RestfulCommonResponse;
import vn.team.system.common.info.RestfulSuccessResponse;
import vn.team.system.common.info.UserInfo;
import vn.team.system.repository.intface.UserRepo;
import vn.team.system.service.intface.UserService;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final Gson gson;
  private final UserRepo userRepo;

  @Override
  public RestfulCommonResponse fetchAll() {
    try {
      List<DepartInfo> output = userRepo.getAll();
      return new RestfulSuccessResponse()
          .setData(gson.toJsonTree(output));
    } catch (Exception e) {
      return new RestfulSuccessResponse()
          .setResponse(CodeResponse.INTERNAL_SERVER)
          .setMessages(e.getMessage());
    }
  }
}
