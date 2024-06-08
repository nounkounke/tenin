package gn.moria.nounkouke.tenin.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TokenClaims {
    EMAIL("email"),
    EMAIL_VERIFIED("email_verified"),
    PICTURE("picture"),
    USER_ID("user_id"),
    ID("id"),
    ZONE_INFO("zoneinfo"),
    LOCAL("local"),
    azp("azp"),
    AUTH_CODE("auth_code"),
    PHONE_NUMBER_VERIFIED("phone_number_verified"),
    PHONE_NUMBER("phone_number"),
    NAME("name"),
    GIVEN_NAME("give_name"),
    NICK_NAME("nick_name"),
    PREFERRED_USERNAME("preferred_username"),
    FAMILY_NAME("family_name"),
    MIDDLE_NAME("middle_name"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    BIRTH_OF_DATE("date_of_birth"),
    PLACE_OF_BIRTH("place_of_birth"),
    GROUPS("groups"),
    ENTITLEMENTS("entitlements"),
    AUTH_LEVLEL("auth_level"),
    UPDATE_AT("updated_at"),
    SALUTATION ("salutation"),
    JTI("jti"),
    PROFILE("profile"),
    AUTH_TIME("auth_time"),
    ROLES("roles"),
    TITLE("title"),
    SUBJECT_JWK("sub_jwk"),
    GENDER("gender"),
    SEX("sex"),
    SUB("sub"),
    ADDRESS("address"),
    STREET_ADDRESS("street_address"),
    ADDRESS_FORMATTED("address_formatted"),
    LOCALITY("locality"),
    COUNTRY("country"),
    POSTAL_CODE("postal_code"),
    REGION("region"),
    ALSO_KNOW_AS("also_known_as"),
    ATC("atc"),
    SUB_ID("sub_id"),
    SID("sid"),
    ACCNT_TYPE("account_type");
    private final String value;
}