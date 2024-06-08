package gn.moria.nounkouke.tenin.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Document {
    private String sku;
    private String name;
    private byte[] content;
    private double size;
    private String extension;
}
