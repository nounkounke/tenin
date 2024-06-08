package gn.moria.nounkouke.tenin.service;

import gn.moria.nounkouke.tenin.entity.UserAccount;
import gn.moria.nounkouke.tenin.exception.UnverifiedEmailAddressException;
import gn.moria.nounkouke.tenin.exception.UnverifiedPhoneNumberException;
import gn.moria.nounkouke.tenin.repository.AccountUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService implements UserDetailsPasswordService {
    private final AccountUserRepository accountUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountStatusUserDetailsChecker userDetailsChecker;

    public UserAccount authorizeUserAccountByEmail(String email, String password) throws UsernameNotFoundException {
        var account = accountUserRepository.findByEmailAddress(email).orElseThrow(()-> new RuntimeException("account not found"));
        String encodedPassword = account.getPassword();

        if (!passwordEncoder.matches(password,encodedPassword)){
            throw new RuntimeException("invalid authentication credentials");
        }

        userDetailsChecker.check(account);

        if (!account.isEmailAddressVerified()){
            throw new UnverifiedEmailAddressException("authentication email address is not verified");
        }

        if (!account.isPhoneNumberVerified()){
            throw new UnverifiedPhoneNumberException("phone number is not verified");
        }
        return account;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }
}
