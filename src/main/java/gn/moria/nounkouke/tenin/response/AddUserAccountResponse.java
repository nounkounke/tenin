package gn.moria.nounkouke.tenin.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddUserAccountResponse {
    private String sku;

    private String firstName;
    private String lastName;
    private String middleName;
    // email address used for creating account
    private String username;
    private String emailAddress;
    private String phoneAddress;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean emailVerified;
}
