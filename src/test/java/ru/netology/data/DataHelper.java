package ru.netology.data;

import lombok.Value;

public class DataHelper {
    public static AuthInfo authInfo;

    private DataHelper() {}

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        DataHelper.authInfo = authInfo;
        return new VerificationCode("12345");
    }

    @Value
    public static class CardsNumber {
        String id;
        String text;

    }

    public static CardsNumber getCardsNumber() {
        return new CardsNumber( "**** **** **** 0001", "**** **** **** 0002" );
    }


}


