package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        open( "http://localhost:9999" );
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin( authInfo );
        val verificationCode = DataHelper.getVerificationCodeFor( authInfo );
        val dashboardPage = verificationPage.validVerify( verificationCode );
        val firstCardBalance = dashboardPage.getCardBalance("0001");
        val secondCardBalance = dashboardPage.getCardBalance("0002");
    }

}

