package gn.moria.nounkouke.tenin.entity;

import gn.moria.nounkouke.tenin.model.Money;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BankPolicy extends BaseMongoAudit {
    private String id;
    private String sku;
    // minimum amount of money required to open an account
    private Money minimumAmount;
}
