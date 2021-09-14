package ch.borja.specalizr.intg.selenium.common;

import ch.borja.specalizr.intg.selenium.action.impl.SeleniumXPathQueryComponentResolver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class LocatorTestBase {

    protected WebDriver webDriver;

    protected SeleniumXPathQueryComponentResolver seleniumXPathQueryComponentVisitor;

    protected WebElement find(final By by) {
        return this.webDriver.findElement(by);
    }

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        this.webDriver = new ChromeDriver(chromeOptions);
        this.seleniumXPathQueryComponentVisitor = new SeleniumXPathQueryComponentResolver();
    }

    @AfterEach
    public void tearDown() {
        this.webDriver.quit();
    }
}
