package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.SubstancesListPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSearch {

    public WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    // Test search with valid cas number
    @Test
    public void test_TC1() {
        SubstancesListPage substanceListPage = new SubstancesListPage(driver);
        String substancePageTitle = substanceListPage.searchResult("7732-18-5");
        assertEquals("Water", substancePageTitle);
    }
}
