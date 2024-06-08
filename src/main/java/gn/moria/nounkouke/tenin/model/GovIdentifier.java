package gn.moria.nounkouke.tenin.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GovIdentifier {
    private String ssn;
    private String taxId;
}
