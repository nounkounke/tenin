package gn.moria.nounkouke.tenin.request;

import gn.moria.nounkouke.tenin.model.Address;
import gn.moria.nounkouke.tenin.model.ContactInfo;
import gn.moria.nounkouke.tenin.model.History;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Builder
@Data
public class AddBankRequest {
    private  String name;

   // @NotBlank(message = "contact info is required")
    private ContactInfo contactInfo;

    //@NotBlank(message = "address  is required")
    private List<Address> address;

    private History history;
}
