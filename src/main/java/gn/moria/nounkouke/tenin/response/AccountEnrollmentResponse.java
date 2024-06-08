package gn.moria.nounkouke.tenin.response;

import gn.moria.nounkouke.tenin.model.GovIdentifier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class AccountEnrollmentResponse {
    private String sku;
    private String bankSku;

    private GovIdentifier govIdentifier;
    private String bankCode;

    private String userAccountSku;

    private Set<String> wallets;
}
