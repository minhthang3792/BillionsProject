package vn.team.system.controller;

import com.google.gson.Gson;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.team.system.common.constant.req_resp.CodeResponse;
import vn.team.system.common.info.RestfulCommonResponse;
import vn.team.system.common.info.RestfulSuccessResponse;
import vn.team.system.common.info.UserInfo;
import vn.team.system.repository.intface.UserRepo;

@RestController
@RequiredArgsConstructor
public class HomeController {

  private final UserRepo userRepo;
  private final Gson gson;

  @GetMapping(value = "home", produces = "application/json")
  @ResponseBody
  public RestfulCommonResponse display() {
    try {
      List<UserInfo> output = userRepo.getAll();
      return new RestfulSuccessResponse().setData(gson.toJsonTree(output));
    } catch (Exception e) {
      return new RestfulSuccessResponse()
          .setResponse(CodeResponse.INTERNAL_SERVER)
          .setMessages(e.getMessage());
    }

  }
}
