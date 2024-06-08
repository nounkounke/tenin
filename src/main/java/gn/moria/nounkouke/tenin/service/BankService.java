package gn.moria.nounkouke.tenin.service;

import gn.moria.nounkouke.tenin.entity.Bank;
import gn.moria.nounkouke.tenin.repository.BankRepository;
import gn.moria.nounkouke.tenin.request.AddBankRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

    public Bank add(AddBankRequest request,String bankCode){
        try {
            var bank = Bank.builder()
                    .sku(UUID.randomUUID().toString())
                    .code(bankCode)
                    .name(request.getName())
                    .address(request.getAddress())
                    .contactInfo(request.getContactInfo())
                    .history(request.getHistory())
                    .build();

            var result = bankRepository.save(bank);
            log.info("created bank with info {}",bank);
            return result;
        }catch (DuplicateKeyException e){
            throw new DuplicateKeyException("unique constraint violation",e);
        }
    }

    public Bank findByCode(String code){
        try{
            var bank = bankRepository.findOneByCode(code).orElseThrow(()-> new RuntimeException("bank institution not found "));
            return bank;
        }catch (Exception e){
            throw new RuntimeException("non-unique bank  institution found using code",e);
        }
    }
}
