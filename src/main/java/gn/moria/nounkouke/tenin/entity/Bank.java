package gn.moria.nounkouke.tenin.entity;

import gn.moria.nounkouke.tenin.model.Address;
import gn.moria.nounkouke.tenin.model.ContactInfo;
import gn.moria.nounkouke.tenin.model.GovIdentifier;
import gn.moria.nounkouke.tenin.model.History;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document("banks")
@Data
@Builder
public class Bank extends BaseMongoAudit{

    @Id
    @MongoId
    private String id;

    @Indexed(unique = true)
    private String sku;


    @Indexed(unique = true)
    private String name;

    @Indexed(unique = true)
    private String code;

    private GovIdentifier govIdentifier;

    @NotBlank(message = "contact info is required")
    private ContactInfo contactInfo;

    @NotBlank(message = "address  is required")
    private List<Address> address;

    private History history;

    private List<Object> customerAccounts;
}
