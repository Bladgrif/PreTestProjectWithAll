package tests.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends BaseTest{

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @DisplayName("Filling out the TextBox form  and checking")
    @Tag("web")
    void fileFormTest() {

        textBoxPage.openPage()
                .SetUserName("Roman Grigorev")
                .SetUserEmail("Roman@gmail.com")
                .SetCurrentAddress("Cheboksary")
                .SetPermanentAddress("Cheboksary-2")
                .pressButton();

        textBoxPage.checkResultName("Roman Grigorev")
                .checkResultEmail("Roman@gmail.com")
                .checkResultCurrentAddress("Cheboksary")
                .checkResultPermanentAddress("Cheboksary-2");
    }

    @Test
    @DisplayName("Negative Filling out the TextBox form  and checking")
    @Tag("web")
    void failFileFormTest() {

        textBoxPage.openPage()
                .SetUserName("Alexey Grigorev")
                .SetUserEmail("Roman@gmail.com")
                .SetCurrentAddress("Cheboksary")
                .SetPermanentAddress("Cheboksary-2")
                .pressButton();

        textBoxPage.checkResultName("Roman Grigorev")
                .checkResultEmail("Roman@gmail.com")
                .checkResultCurrentAddress("Cheboksary")
                .checkResultPermanentAddress("Cheboksary-2");
    }
}
