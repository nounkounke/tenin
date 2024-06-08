package gn.moria.nounkouke.tenin.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Data
public class ApiResponse {
    private final String message;
    private final Object payload;
}
