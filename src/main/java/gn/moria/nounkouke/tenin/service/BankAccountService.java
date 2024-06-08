package gn.moria.nounkouke.tenin.service;

import gn.moria.nounkouke.tenin.entity.Bank;
import gn.moria.nounkouke.tenin.entity.BankAccount;
import gn.moria.nounkouke.tenin.repository.BankAccountRepository;
import gn.moria.nounkouke.tenin.request.UserAccountEnrollmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;


    public BankAccount enrollUserAccount(UserAccountEnrollmentRequest request, String userAccountSku, Bank bank){
        try{
            // TODO create empty checking wallet for user at bank account creation
            var bankAccount = BankAccount.builder()
                    .userAccountSku(userAccountSku)
                    .bankSku(bank.getSku())
                    .govIdentifier(request.getGovIdentifier())
                    .wallets(new HashSet<>())
                    .build();

            return bankAccountRepository.save(bankAccount);
        }catch (DuplicateKeyException e){
            throw new RuntimeException("duplicate keys found while creating account",e);
        }
    }

}
