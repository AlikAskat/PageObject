package ru.netology.data;

import lombok.Value;

public class DataHelper {
    public static AuthInfo authInfo;
    private static AuthInfo original;

    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        DataHelper.original = original;
        return new AuthInfo("petya", "123qwerty");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        DataHelper.authInfo = authInfo;
        return new VerificationCode("12345");
    }
}

