package vn.team.system.common.info;

import com.google.gson.JsonObject;
import vn.team.system.common.constant.req_resp.CodeResponse;


public class RestfulFailureResponse extends RestfulCommonResponse {

  public RestfulFailureResponse() {
    this.status = false;
    this.code = CodeResponse.BAD_REQUEST.getCode();
    this.messages = CodeResponse.BAD_REQUEST.getMessage();
    this.data = new JsonObject();
  }

}
