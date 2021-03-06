package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        SelenideElement heading = $( "[data-test-id='dashboard']" );
        heading.shouldBe(visible);
    }


    public int getCardBalance(String id) {
        val text = cards.find(text(id)).getText();
        $( byText( "Пополнить" ) ).click();
        $("[maxlength='14']").setValue( "100" );
        $("[maxlength='19']").setValue("'5559 0000 0000 0002");
        $("[class='App_appContainer__3jRx1']").waitUntil( Condition.visible, 15000);
        $( "[data-test-id='action-transfer']").click();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}



