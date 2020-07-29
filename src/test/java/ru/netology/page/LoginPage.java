package ru.netology.page;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        open("http://localhost:9999");
        $("[class=App_appContainer__3jRx1]");
        $( byText( "Логин" )).setValue( info.getLogin() );
        $( "[data-test-id='password'] input" ).setValue( info.getPassword() );
        $( "[data-test-id=action-login]" ).click();
        return new VerificationPage();
    }
}


