package gn.moria.nounkouke.tenin.util;

import java.util.UUID;

public class SkuUtil {
    public static String generateForBank(String name,String country){
        return UUID.randomUUID().toString();
    }
}
