package tests.selenide;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPageSelenide;

public class TextBoxTest extends BaseTest{

    TextBoxPageSelenide textBoxPageSelenide = new TextBoxPageSelenide();

    @Test
    @DisplayName("Filling out the TextBox form  and checking Selenide")
    @Tag("WEB")
    @Disabled
    void fileFormTest() {

        textBoxPageSelenide.openPage()
                .SetUserName("Roman Grigorev")
                .SetUserEmail("Roman@gmail.com")
                .SetCurrentAddress("Cheboksary")
                .SetPermanentAddress("Cheboksary-2")
                .pressButton();

        textBoxPageSelenide.checkResultName("Roman Grigorev")
                .checkResultEmail("Roman@gmail.com")
                .checkResultCurrentAddress("Cheboksary")
                .checkResultPermanentAddress("Cheboksary-2");
    }

    @Test
    @DisplayName("Negative Filling out the TextBox form  and checking Selenide")
    @Tag("WEB")
    @Disabled
    void failFileFormTest() {

        textBoxPageSelenide.openPage()
                .SetUserName("Alexey Grigorev")
                .SetUserEmail("Roman@gmail.com")
                .SetCurrentAddress("Cheboksary")
                .SetPermanentAddress("Cheboksary-2")
                .pressButton();

        textBoxPageSelenide.checkResultName("Roman Grigorev")
                .checkResultEmail("Roman@gmail.com")
                .checkResultCurrentAddress("Cheboksary")
                .checkResultPermanentAddress("Cheboksary-2");
    }
}
