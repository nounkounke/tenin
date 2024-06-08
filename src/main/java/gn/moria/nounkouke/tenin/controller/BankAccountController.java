package gn.moria.nounkouke.tenin.controller;

import gn.moria.nounkouke.tenin.model.TokenClaims;
import gn.moria.nounkouke.tenin.request.MerchantAccountEnrollmentRequest;
import gn.moria.nounkouke.tenin.request.UserAccountEnrollmentRequest;
import gn.moria.nounkouke.tenin.response.AccountEnrollmentResponse;
import gn.moria.nounkouke.tenin.response.ApiResponse;
import gn.moria.nounkouke.tenin.service.BankAccountService;
import gn.moria.nounkouke.tenin.service.BankService;
import gn.moria.nounkouke.tenin.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("banks")
@RequiredArgsConstructor
@Slf4j
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final BankService bankService;

    @PostMapping("accounts/{bankCode}/users")
    public ResponseEntity<ApiResponse> selfEnrollUserAccount(@RequestBody UserAccountEnrollmentRequest request,
                                                             @PathVariable String bankCode,
                                                             @RequestHeader(value = HttpHeaders.AUTHORIZATION,required = true) String authorization){

        var bank = bankService.findByCode(bankCode);
        String userAccountSku = JwtTokenUtil.getSubject(authorization);
        var result = bankAccountService.enrollUserAccount(request,userAccountSku,bank);

        var response = AccountEnrollmentResponse.builder()
                .userAccountSku(result.getUserAccountSku())
                .bankCode(result.getBankCode())
                .govIdentifier(result.getGovIdentifier())
                .sku(result.getSku())
                .bankSku(request.getBankSku())
                .build();

        var apiResponse = ApiResponse.builder()
                .payload(response)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PostMapping("{bankCode}/merchant")
    public ResponseEntity<ApiResponse> selfEnrollMerchantAccount(@RequestBody MerchantAccountEnrollmentRequest request){
        return null;
    }

    @PostMapping("{bankCode}/users/assist")
    public ResponseEntity<ApiResponse> assistedEnrollUserAccount(){
        return null;
    }

    @PostMapping("{bankCode}/merchant/assist")
    public ResponseEntity<ApiResponse> assistedEnrollMerchantAccount(){
        return null;
    }
}
