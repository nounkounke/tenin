package gn.moria.nounkouke.tenin.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ContactInfo {
    private List<NameValuePair> emails;
    private List<NameValuePair> websites;
    private List<NameValuePair> phones;

}
