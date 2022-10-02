package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    private final String url = "https://nist-api-frontend.vercel.app/";

    // Locators
    private By substancesListButtonBy = By.className("btn");
    private By pageH1SpanTextBy = By.xpath("//h1/span/small/text()");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public String clickSubstancesListButton() {
        driver.findElement(substancesListButtonBy).click();
        WebElement pageTitle = driver.findElement(pageH1SpanTextBy);
        driver.get(url);
        return pageTitle.getText();
    }

}