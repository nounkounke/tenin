package gn.moria.nounkouke.tenin.controller;

import gn.moria.nounkouke.tenin.request.AddBankRequest;
import gn.moria.nounkouke.tenin.request.MerchantAccountEnrollmentRequest;
import gn.moria.nounkouke.tenin.request.UserAccountEnrollmentRequest;
import gn.moria.nounkouke.tenin.response.ApiResponse;
import gn.moria.nounkouke.tenin.service.BankService;
import gn.moria.nounkouke.tenin.util.BankUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("banks")
@RequiredArgsConstructor
public class BankManagementController {
    private final BankService bankService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> add(@RequestBody @Valid AddBankRequest request){
        String bankCode = BankUtil.generateBankCode(request.getAddress().get(0).getCountryCode());

        var result = bankService.add(request,bankCode);
        var response = ApiResponse.builder()
                .payload(result)
                .message("bank institution created")
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
