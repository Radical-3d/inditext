package vo;

import lombok.Data;

@Data
public class UserVO {

    private String userId;

    private String password;

    private String roles;

    private String scopes;
}
