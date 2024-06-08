package gn.moria.nounkouke.tenin.repository;

import gn.moria.nounkouke.tenin.entity.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountRepository  extends MongoRepository<BankAccount,String> {

}
