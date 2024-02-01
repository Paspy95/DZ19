package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationOfCardDelivery {
    public String generateDate(int days, String pattern) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test

    public void theCardWithDelivery() {

        open("http://localhost:9999/");
        $("[data-test-id='city'] input ").setValue("Майкоп");
        $("[data-test-id='date'] input ").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = generateDate(4, "dd.MM.yyyy");
        $("[data-test-id='date'] input ").setValue(planningDate);
        $("[data-test-id='name'] input ").setValue("Гудов Роман");
        $("[data-test-id='phone'] input ").setValue("+79131231265");
        $("[data-test-id='agreement']").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + planningDate));


    }

}
