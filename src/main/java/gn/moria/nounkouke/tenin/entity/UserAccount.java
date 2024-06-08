package gn.moria.nounkouke.tenin.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Document("user_account")
@NoArgsConstructor
public class UserAccount implements UserDetails {

    @Id
    @MongoId
    private String id;

    @Indexed(unique = true)
    private String sku;

    private String firstName;
    private String lastName;
    private String middleName;
    private String password;
    // email address used for creating account

    @Indexed(unique = true)
    private String username;

    @Indexed(unique = true)
    private String emailAddress;

    @Indexed(unique = true)
    private String phoneNumber;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean emailAddressVerified;
    private boolean phoneNumberVerified;
    private boolean passwordExpired;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
