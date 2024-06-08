package gn.moria.nounkouke.tenin.request;

import gn.moria.nounkouke.tenin.model.ContactInfo;
import gn.moria.nounkouke.tenin.model.Dob;
import gn.moria.nounkouke.tenin.model.GovIdentifier;
import gn.moria.nounkouke.tenin.model.Sex;
import gn.moria.nounkouke.tenin.validation.AddUserAccountRequestValidator;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated(AddUserAccountRequestValidator.class)
@Data
public class AddUserAccountRequest {
    private List<String> title;
    private String firstName;
    private String lastName;
    private String middleName;
    private String password;
    private String username;
    private String emailAddress;
    private String phoneNumber;
    private Dob dob;
    private Sex sex;
    private GovIdentifier govIdentifier;
    private ContactInfo contactInfo;
}
