package gn.moria.nounkouke.tenin.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticateRequest {

    @NotBlank(message = "email is required")
    private String emailAddress;

    @NotBlank(message = "secret is required")
    private String secret;
}
