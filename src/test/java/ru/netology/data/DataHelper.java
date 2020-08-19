package ru.netology.data;

import lombok.Value;

public class DataHelper {
    public static AuthInfo authInfo;
    private static String firstCardBalance;
    private static String secondCardBalance;


    private DataHelper() {}

    public static String getFirstCardBalance() {
        return firstCardBalance;
    }

    public static void setFirstCardBalance(String firstCardBalance) {
        DataHelper.firstCardBalance = firstCardBalance;
    }

    public static String getSecondCardBalance() {
        return secondCardBalance;
    }

    public static void setSecondCardBalance(String secondCardBalance) {
        DataHelper.secondCardBalance = secondCardBalance;
    }

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

}


