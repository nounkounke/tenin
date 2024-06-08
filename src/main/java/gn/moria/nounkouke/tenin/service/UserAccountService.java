package gn.moria.nounkouke.tenin.service;

import gn.moria.nounkouke.tenin.entity.UserAccount;
import gn.moria.nounkouke.tenin.repository.AccountUserRepository;
import gn.moria.nounkouke.tenin.request.AddUserAccountRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAccountService {
    private final AccountUserRepository accountUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserAccount add(AddUserAccountRequest request){

        try {

            // TODO set emailAddress and phoneNumberVerified to false initially
            var account = modelMapper.map(request, UserAccount.class);
            account.setAccountNonExpired(true);
            account.setEnabled(true);
            account.setCredentialsNonExpired(true);
            account.setAccountNonLocked(true);
            account.setEmailAddressVerified(true);
            account.setPhoneNumberVerified(true);
            account.setSku(UUID.randomUUID().toString());

            var password = passwordEncoder.encode(request.getPassword());

            account.setPassword(password);

            var result = accountUserRepository.save(account);
            return  result;
        }catch (DuplicateKeyException e){
            throw new DuplicateKeyException("uniqueness constraint violation while saving account",e);
        }
    }
}
