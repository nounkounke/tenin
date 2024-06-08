package gn.moria.nounkouke.tenin.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    //private String sku;
    private Integer countryCode;
    private String street;
    private String city;
    private String state;
    private Integer postalCode;
}
