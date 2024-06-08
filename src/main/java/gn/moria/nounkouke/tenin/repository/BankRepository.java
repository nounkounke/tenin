package gn.moria.nounkouke.tenin.repository;

import gn.moria.nounkouke.tenin.entity.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankRepository  extends MongoRepository<Bank,String> {
    Optional<Bank> findByCode(String code);
    Optional<Bank> findOneByCode(String code);
}
