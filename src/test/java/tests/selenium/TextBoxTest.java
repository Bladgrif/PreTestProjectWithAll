package tests.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.TextBoxPageSelenide;
import pages.TextBoxPageSelenium;

import static java.lang.Thread.sleep;

public class TextBoxTest {
    private final WebDriver driver = new ChromeDriver();
    private final TextBoxPageSelenium textBoxPageSelenium = new TextBoxPageSelenium(driver);

    @Test
    @DisplayName("Filling out the TextBox form  and checking Selenium")
    @Tag("WEB")
    public void testTextBox(){
        textBoxPageSelenium.openPage()
                .setUserName("Roman Grigorev")
                .setUserEmail("Roman@gmail.com")
                .setCurrentAddress("Cheboksary")
                .setPermanentAddress("Cheboksary-2")
                .pressButton();
//sleep(3000);
        textBoxPageSelenium.checkResultName("Roman Grigorev")
                .checkResultEmail("Roman@gmail.com")
                .checkResultCurrentAddress("Cheboksary")
                .checkResultPermanentAddress("Cheboksary-2");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
