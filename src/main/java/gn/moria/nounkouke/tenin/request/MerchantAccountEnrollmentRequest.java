package gn.moria.nounkouke.tenin.request;

import gn.moria.nounkouke.tenin.model.GovIdentifier;
import gn.moria.nounkouke.tenin.model.Money;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated(MerchantAccountEnrollmentRequest.class)
public class MerchantAccountEnrollmentRequest {
    private GovIdentifier govIdentifier;
    private Money money;
}
