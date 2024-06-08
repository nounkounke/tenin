package gn.moria.nounkouke.tenin.model;

import lombok.Data;

@Data
public class NameValuePair {
    private String name;
    private String value;
    private boolean primary;
}
