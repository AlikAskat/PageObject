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

    @Value
    public static class CardBalance {
        String id;
        String text;

    }

    public static CardBalance getCardBalance() {
        return new CardBalance("0001", "0002");
    }

//    @Value
//    public static class FirstCardBalance {
//        firstCardBalance;
//    }
//
//
//    public static FirstCardBalance firstCardBalance() {
//        return new FirstCardBalance();
//    }
//
//    @Value
//    public static class SecondCardBalance {
//        secondCardBalance;
//    }
//
//    public static SecondCardBalance secondCardBalance() {
//        return new SecondCardBalance();
//    }

}


