package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationOfCardDelivery {

    @Test

    public void theCardWithDelivery() {

        open("http://localhost:9999/");
        $("[data-test-id='city'] input ").setValue("Майкоп");
        $("[data-test-id='date'] input ").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id='date'] input ").setValue("06.02.2024");
        $("[data-test-id='name'] input ").setValue("Гудов Роман");
        $("[data-test-id='phone'] input ").setValue("+79131231265");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + "06.02.2024"));


    }

}
