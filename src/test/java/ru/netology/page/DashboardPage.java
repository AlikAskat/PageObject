package ru.netology.page;

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
//        val string = balanceStart.equals("[label='Сумма']");
        $( byText( "Пополнить" ) ).click();
        $("#root > div > form > fieldset > div:nth-child(1) > div > span > span > span.input__box > input").setValue( "100" );
        $("#root > div > form > fieldset > div:nth-child(2) > span > span > span.input__box > input").setValue("'5559 0000 0000 0002");
//        ("[data-test-id='amount']");
//        ( "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']" );
//        $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").click();
//        $("[class='money-input__currency']");
//        $("[placeholder='0000 0000 0000 0000']");
//        $("[value='**** **** ****']");
        $( byText( "Пополнить" ) ).click();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}



