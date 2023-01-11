package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SampleTestSteps {
    WebDriver driver;
    String URL = "https://www.google.com/";
    String expectedTitleForHomePage = "Google";
    String expectedTitleForSearchResultPage= "Phone Booth - Google Search";

    @Given("User opens home page")
    public void openHomePage() {
        System.setProperty("driver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        Assert.assertEquals("Title mismatched", expectedTitleForHomePage, driver.getTitle());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@title='Search']")).isDisplayed());
    }

    @When("User searches {string}")
    public void searchByKeyword(String keyword) {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(keyword);
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
    }

    @Then("User validates the search result as {string}")
    public void validateTheSearchResult(String result) {
        boolean flag = driver.findElement(By.xpath("//span[@role='heading' and text()='"+result+"']")).isDisplayed();
        Assert.assertTrue("Heading of the searched keyword is not visible",flag);
        Assert.assertEquals("Title mismatched after searching", expectedTitleForSearchResultPage, driver.getTitle());
        driver.quit();
    }
}
