package gn.moria.nounkouke.tenin.repository;

import gn.moria.nounkouke.tenin.entity.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountUserRepository extends MongoRepository<UserAccount,String> {
    Optional<UserAccount> findByEmailAddress(String email);
}
