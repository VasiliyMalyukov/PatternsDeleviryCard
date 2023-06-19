package ru.netology.pages;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class CardApplicationForm {
    private final SelenideElement mainElement = $("[data-test-id='city'] input");
    private final SelenideElement cityInput = $("[data-test-id='city'] input");
    private final SelenideElement cityValidation = $("[data-test-id='city'] .input__sub");
    private final SelenideElement nameInput = $("[data-test-id='name'] input");
    private final SelenideElement nameValidation = $("[data-test-id='name'] .input__sub");
    private final SelenideElement phoneInput = $("[data-test-id='phone'] input");
    private final SelenideElement phoneValidation = $("[data-test-id='phone'] .input__sub");
    private final SelenideElement agreementCheckbox = $("[data-test-id='agreement'] .checkbox__box");
    private final SelenideElement submitButton = $x("//button//span[text()='Запланировать']");
    private final SelenideElement dateButton = $("[data-test-id='date'] button");
    private final SelenideElement dateInput = $("[data-test-id='date'] input");
    private final SelenideElement dateValidation = $("[data-test-id='date'] .input__sub");
    private final ElementsCollection calendarPopupContent = $$(".calendar-input__calendar-wrapper tbody tr");
    private final SelenideElement calendarCurrentDay = $(".calendar__day.calendar__day_state_current");
    private final SelenideElement notificationPopover = $(".notification_visible[data-test-id='success-notification']");
    private final SelenideElement notificationContent = notificationPopover.$(".notification__content");
    private final SelenideElement replanPopover = $(".notification_visible[data-test-id='replan-notification']");
    private final SelenideElement replanButton = replanPopover.$x(".//span[text()='Перепланировать']");
    private final SelenideElement submitButtonIcon = $(".button__icon > span");


    public CardApplicationForm() {
        Selenide.open("/");
        mainElement.shouldBe(visible);
    }


    public CardApplicationForm setCity(String cityName) {
        cityInput
                .should(visible)
                .setValue(cityName);
        return this;
    }

    public CardApplicationForm setName(String name) {
        nameInput
                .should(visible)
                .setValue(name);
        return this;
    }

    public CardApplicationForm clickAgreementCheckbox() {
        agreementCheckbox
                .should(visible)
                .click();
        return this;
    }

    public CardApplicationForm setSpecificDate(String date) {
        setEmptyDate();
        dateInput.setValue(date);

        return this;
    }

    public CardApplicationForm clickSubmitButton() {
        submitButton
                .should(visible)
                .click();
        return this;
    }

    private CardApplicationForm clickDateButton() {
        dateButton
                .should(visible)
                .click();
        return this;
    }

    public CardApplicationForm setCurrentDay() {
        clickDateButton();
        calendarPopupContent
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        calendarCurrentDay.click();
        return this;
    }

    public CardApplicationForm setEmptyDate() {
        dateInput
                .shouldBe(visible)
                .sendKeys(Keys.CONTROL, Keys.BACK_SPACE);
        return this;
    }

    public CardApplicationForm submitButtonShouldHaveSpinner() {
        submitButtonIcon
                .shouldBe(visible)
                .shouldHave(attribute("class", "spin_visible"));
        return this;
    }

    public CardApplicationForm submitButtonShouldNotHaveSpinner() {
        submitButtonIcon.shouldNotHave(attribute("class", "spin_visible"),
                Duration.ofSeconds(15));
        return this;
    }

    public CardApplicationForm successNotificationShouldBeVisible(String deliveryDate) {
        notificationPopover.shouldBe(visible);
        notificationContent.shouldHave(exactTextCaseSensitive(
                format("Встреча успешно запланирована на %s", deliveryDate)));
        return this;
    }

    public CardApplicationForm setPhone(String phone) {
        phoneInput
                .should(visible)
                .setValue(phone);
        return this;
    }

    public CardApplicationForm agreementCheckboxShouldHaveValidationError() {
        agreementCheckbox
                .parent()
                .shouldHave(attribute("class", "checkbox checkbox_size_m checkbox_theme_alfa-on-white input_invalid"));
        return this;
    }

    public CardApplicationForm phoneValidationShouldHaveText(String text) {
        phoneValidation
                .shouldBe(visible)
                .shouldHave(exactTextCaseSensitive(text));
        return this;
    }

    public CardApplicationForm cityValidationShouldHaveText(String text) {
        cityValidation
                .shouldBe(visible)
                .shouldHave(exactTextCaseSensitive(text));
        return this;
    }

    public CardApplicationForm nameValidationShouldHaveText(String text) {
        nameValidation
                .shouldBe(visible)
                .shouldHave(exactTextCaseSensitive(text));
        return this;
    }

    public CardApplicationForm replanPopoverShouldBeVisible() {
        replanPopover.shouldBe(visible);
        return this;
    }

    public CardApplicationForm clickReplanButton() {
        replanButton
                .shouldBe(visible)
                .click();
        return this;
    }

    public CardApplicationForm dateValidationShouldHaveText(String text) {
        dateValidation
                .shouldBe(visible)
                .shouldHave(exactTextCaseSensitive(text));
        return this;
    }


}
