package gn.moria.nounkouke.tenin.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class TokenInput {
    private String subject;
    Map<String,Object> claims;
}