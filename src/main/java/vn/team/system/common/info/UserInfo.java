package vn.team.system.common.info;

import lombok.Data;
import lombok.experimental.Accessors;
import vn.team.system.common.annotation.CanNullOrEmpty;

@Data
@Accessors(chain = true)
public class UserInfo {

    private String username;
    private String password;
    private String fullName;
    private String address;
}
