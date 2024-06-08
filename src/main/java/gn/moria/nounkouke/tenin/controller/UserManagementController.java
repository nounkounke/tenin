package gn.moria.nounkouke.tenin.controller;

import gn.moria.nounkouke.tenin.request.AddUserAccountRequest;
import gn.moria.nounkouke.tenin.response.AddUserAccountResponse;
import gn.moria.nounkouke.tenin.response.ApiResponse;
import gn.moria.nounkouke.tenin.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Slf4j
public class UserManagementController {
    private final UserAccountService userAccountService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody @Valid AddUserAccountRequest request){
        var result = userAccountService.add(request);
        var response = modelMapper.map(result, AddUserAccountResponse.class);

        var apiResponse = ApiResponse.builder()
                .message("new user account created")
                .payload(response)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

}
