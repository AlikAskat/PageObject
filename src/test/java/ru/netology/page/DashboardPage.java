package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.impl.Html.text;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item");
    private String balanceStart = "баланс: ";
    private String extractBalance;
    private final String balanceFinish = " р.";

    public DashboardPage() {
        SelenideElement heading = $( "[data-test-id='dashboard']" );
        heading.shouldBe(visible);
    }

    public int getBalanceStart(String balanceStart, String extractBalance) {
        this.balanceStart = balanceStart;
        this.extractBalance = extractBalance;
//        private balanceStart = new balanceStart();
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
        $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
        return extractBalance( String.valueOf( text ) );
    }
//    public String getBalanceFinish() {
//        return balanceFinish;
//    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

}



