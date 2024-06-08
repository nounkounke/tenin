package gn.moria.nounkouke.tenin.entity;

import gn.moria.nounkouke.tenin.model.Transaction;
import gn.moria.nounkouke.tenin.model.WalletType;
import gn.moria.nounkouke.tenin.model.Money;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Document("wallets")
@Data
@Builder
public class Wallet extends BaseMongoAudit {

    @Id
    @MongoId
    private String id;
    private String sku;
    private Money balance;
    private WalletType type;
    private Set<Transaction> transfers;
}
