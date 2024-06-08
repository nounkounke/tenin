package gn.moria.nounkouke.tenin.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Currency {
    GNF("Guinean Franc"),USD("US Dollar"),EURO("Euro");

    private final String value;
}
