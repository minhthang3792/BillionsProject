package vn.team.system.common.constant.req_resp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeResponse {

  INTERNAL_SERVER(500, "Internal Server Error"),
  BAD_REQUEST(400, "Bad Request"),
  OK(200, "OK");

  Integer code;
  String description;
}
