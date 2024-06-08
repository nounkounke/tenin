package gn.moria.nounkouke.tenin.response;

import gn.moria.nounkouke.tenin.model.Address;
import gn.moria.nounkouke.tenin.model.ContactInfo;
import gn.moria.nounkouke.tenin.model.History;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@Data
public class AddBankResponse {
    private String sku;
    private String name;
    private String code;
    private ContactInfo contactInfo;
    private Address address;
    private History history;
}
