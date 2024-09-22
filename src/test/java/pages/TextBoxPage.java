package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
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

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage SetUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage SetCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage SetPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage SetUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage pressButton() {
        submit.click();
        return this;
    }

    public TextBoxPage checkResultName(String value) {
        resultName.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkResultEmail(String value) {
        resultEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkResultCurrentAddress(String value) {
        resultCurrentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkResultPermanentAddress(String value) {
        resultPermanentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage openPageParametrized() {
        open("/links");
        return this;
    }

    public TextBoxPage openCategory(String value) {
        menu_list.$(byText(value)).click();
        return this;
    }

    public TextBoxPage checkCategory(String value) {
        header.shouldHave(text(value));
        return this;
    }
    public TextBoxPage checkUserForm(String value) {
        userForm.$(byText(value)).shouldHave(text(value));
        return this;
    }

}