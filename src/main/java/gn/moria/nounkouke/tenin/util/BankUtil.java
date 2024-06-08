package gn.moria.nounkouke.tenin.util;

import java.util.UUID;

public class BankUtil {
    public static String generateBankCode(int countryCode){
        return String.valueOf(countryCode).concat("&").concat(UUID.randomUUID().toString());
    }
}
