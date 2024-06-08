package gn.moria.nounkouke.tenin.controller;

import gn.moria.nounkouke.tenin.model.AccountConstants;
import gn.moria.nounkouke.tenin.model.TokenClaims;
import gn.moria.nounkouke.tenin.model.TokenInput;
import gn.moria.nounkouke.tenin.request.AuthenticateRequest;
import gn.moria.nounkouke.tenin.response.ApiResponse;
import gn.moria.nounkouke.tenin.service.AuthenticationService;
import gn.moria.nounkouke.tenin.util.JwtTokenUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("users")
    public ResponseEntity<ApiResponse> authenticate(@RequestBody @Valid AuthenticateRequest request){

        var result = authenticationService.authorizeUserAccountByEmail(request.getEmailAddress(),request.getSecret());

        Map<String,Object> claims = new HashMap<>();

        claims.put(TokenClaims.EMAIL.getValue(),result.getEmailAddress());
        claims.put(TokenClaims.USER_ID.getValue(),result.getSku());
        claims.put(TokenClaims.EMAIL_VERIFIED.getValue(),result.isEmailAddressVerified());
        claims.put(TokenClaims.AUTH_TIME.getValue(), new Date());
        claims.put(TokenClaims.ACCNT_TYPE.getValue(), AccountConstants.USER_ACCOUNT);

        var tokenInput = TokenInput.builder()
                .claims(claims)
                .build();

        String accessToken = JwtTokenUtil.generateToken(tokenInput);

        var apiResponse = ApiResponse.builder()
                .message("user account authentication success")
                .payload(accessToken)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
