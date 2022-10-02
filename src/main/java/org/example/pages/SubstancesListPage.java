package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubstancesListPage {

    private final WebDriver driver;
    private WebDriverWait wait;
    private final String url = "https://nist-api-frontend.vercel.app/substances/page/1";

    // Locators
    private By searchBy = By.id("search");
    private By SubstancesListBy = By.cssSelector(".substances .card");
    private By SubstanceTitleBy = By.tagName("h2");
    private By FirstSubstanceLinkBy = By.cssSelector(".substances .card:first-child a");

    public SubstancesListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String searchResult (String casNumber) {
        driver.get(url);
        WebElement searchField = driver.findElement(searchBy);
        searchField.sendKeys(casNumber);
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlToBe("https://nist-api-frontend.vercel.app/substances/cas/"+casNumber.replace("-", "")));
        WebElement SubstanceTitle = driver.findElement(SubstanceTitleBy);
        String substanceTitleText = SubstanceTitle.getText();
        driver.get(url); // Return to original url after being redirected by the search.
        return substanceTitleText;
    }

    public List<WebElement> substanceList() {
        driver.get(url);
        return driver.findElements(SubstancesListBy);
    }

    public List<String> goToFirstSubstancePage() {
        driver.get(url);
        WebElement firstSubstanceLink = driver.findElement(FirstSubstanceLinkBy);
        firstSubstanceLink.click();
        WebElement SubstanceTitle = driver.findElement(SubstanceTitleBy);
        driver.get(url); // Return to original url after being redirected by the search.
        return List.of(firstSubstanceLink.getText(), SubstanceTitle.getText());
    }
}
