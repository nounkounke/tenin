package gn.moria.nounkouke.tenin.entity;

import gn.moria.nounkouke.tenin.model.GovIdentifier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class BankAccount extends  BaseMongoAudit {
    @MongoId
    @Id
    private String id;
    @NotBlank(message = "sku is required")
    private String sku;

    //TODO revisit
    @Indexed(unique = true)
    @NotBlank(message = "bankSku is required")
    private String bankSku;

    @NotNull(message = "govIdentifier is required")
    private GovIdentifier govIdentifier;

    @Indexed
    @NotBlank(message = "bankCode is required")
    private String bankCode;

    @Indexed
    @NotBlank(message = "accountSku is required")
    private String userAccountSku;

    @Builder.Default
    private Set<String> wallets = new HashSet<>();
}
