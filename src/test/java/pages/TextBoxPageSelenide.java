package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPageSelenide {
    SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress"),
            menu_list = $(".menu-list"),
            header = $(".pattern-backgound.playgound-header"),
            userForm = $("#userForm");

    public TextBoxPageSelenide openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPageSelenide SetUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPageSelenide SetCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPageSelenide SetPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPageSelenide SetUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPageSelenide pressButton() {
        submit.click();
        return this;
    }

    public TextBoxPageSelenide checkResultName(String value) {
        resultName.shouldHave(text(value));
        return this;
    }

    public TextBoxPageSelenide checkResultEmail(String value) {
        resultEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPageSelenide checkResultCurrentAddress(String value) {
        resultCurrentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPageSelenide checkResultPermanentAddress(String value) {
        resultPermanentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPageSelenide openPageParametrized() {
        open("/links");
        return this;
    }

    public TextBoxPageSelenide openCategory(String value) {
        menu_list.$(byText(value)).click();
        return this;
    }

    public TextBoxPageSelenide checkCategory(String value) {
        header.shouldHave(text(value));
        return this;
    }
    public TextBoxPageSelenide checkUserForm(String value) {
        userForm.$(byText(value)).shouldHave(text(value));
        return this;
    }

}