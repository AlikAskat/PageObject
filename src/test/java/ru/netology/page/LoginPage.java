package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        $( "[class='input__inner'] input" ).setValue( info.getLogin() );
        $( "[data-test-id='password'] input" ).setValue( info.getPassword() );
        $( "[data-test-id='action-login']" ).click();
        return new VerificationPage();
    }
}


