package vn.team.system.common.info;

import com.google.gson.JsonObject;
import vn.team.system.common.constant.req_resp.CodeResponse;

public class RestfulSuccessResponse extends RestfulCommonResponse {

  public RestfulSuccessResponse() {
    this.status = true;
    this.code = CodeResponse.OK.getCode();
    this.messages = CodeResponse.OK.getMessage();
    this.data = new JsonObject();
  }

}
