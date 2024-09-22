package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPageSelenium{

    private WebDriver driver;

    public TextBoxPageSelenium(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для открытия страницы
    public TextBoxPageSelenium openPage() {
        driver.get("https://demoqa.com/text-box"); // замените на реальный URL
        return this;
    }

    // Метод для установки имени пользователя
    public TextBoxPageSelenium setUserName(String name) {
        driver.findElement(By.id("userName")).sendKeys(name); // замените на правильный локатор
        return this;
    }

    // Метод для установки email
    public TextBoxPageSelenium setUserEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email); // замените на правильный локатор
        return this;
    }

    // Метод для установки текущего адреса
    public TextBoxPageSelenium setCurrentAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address); // замените на правильный локатор
        return this;
    }

    // Метод для установки постоянного адреса
    public TextBoxPageSelenium setPermanentAddress(String address) {
        driver.findElement(By.id("permanentAddress")).sendKeys(address); // замените на правильный локатор
        return this;
    }

    // Метод для нажатия кнопки
    public TextBoxPageSelenium pressButton() {
        driver.findElement(By.id("submit")).click(); // замените на правильный локатор
        return this;
    }

    // Проверка результатов
    public TextBoxPageSelenium checkResultName(String expectedName) {
        String actualName = driver.findElement(By.cssSelector("#output #name")).getText().split(":")[1].trim();; // замените на правильный локатор
        System.out.println(actualName);
        assert actualName.equals(expectedName) : "The name doesn't match!";
        return this;
    }



    public TextBoxPageSelenium checkResultEmail(String expectedEmail) {
        String actualEmail = driver.findElement(By.cssSelector("#output #email")).getText().split(":")[1].trim().split(" ")[0];; // замените на правильный локатор
        assert actualEmail.equals(expectedEmail) : "Email doesn't match!";
        return this;
    }

    public TextBoxPageSelenium checkResultCurrentAddress(String expectedAddress) {
        String actualAddress = driver.findElement(By.cssSelector("#output #currentAddress")).getText().split(":")[1].trim().split(" ")[0];; // замените на правильный локатор
        assert actualAddress.equals(expectedAddress) : "The current address does not match!";
        return this;
    }

    public TextBoxPageSelenium checkResultPermanentAddress(String expectedAddress) {
        String actualAddress = driver.findElement(By.cssSelector("#output #permanentAddress")).getText().split(":")[1].trim().split(" ")[0];; // замените на правильный локатор
        assert actualAddress.equals(expectedAddress) : "Permanent address does not match!";
        return this;
    }
}
