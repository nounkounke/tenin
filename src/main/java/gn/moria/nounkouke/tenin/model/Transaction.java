package gn.moria.nounkouke.tenin.model;

import gn.moria.nounkouke.tenin.entity.BaseMongoAudit;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Transaction extends BaseMongoAudit {
    private String fromWalletSku;
    private String toWalletSku;
    private Money money;
    private String note;
}
