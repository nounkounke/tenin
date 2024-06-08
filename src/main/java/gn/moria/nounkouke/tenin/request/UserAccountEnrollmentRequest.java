package gn.moria.nounkouke.tenin.request;

import gn.moria.nounkouke.tenin.model.GovIdentifier;
import gn.moria.nounkouke.tenin.model.Money;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated(UserAccountEnrollmentRequest.class)
public class UserAccountEnrollmentRequest {
    private GovIdentifier govIdentifier;
    private Money money;
    private String bankSku;
    private String userAccountSku;
}
