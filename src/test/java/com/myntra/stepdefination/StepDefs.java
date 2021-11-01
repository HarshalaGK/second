package com.myntra.stepdefination;

import com.myntra.PageObject.SearchPage;
import com.myntra.core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//import org.apache.logging.log4j.LogManager;

public class StepDefs {
    //  private static final Logger logger = (Logger) LogManager.getLogger(StepDefs.class);
    public WebDriver driver;
    //int implicit_wait_timeout_in_sec = 20;
//    Scenario scn; // this is set in the @Before method
    SearchPage searchPage;

    @Given("User is on landing page")
    public void user_is_on_landing_page() {

        driver = Base.getDriver();

    }
    @When("user search for {string}")
    public void user_search_for(String arg1) {
        searchPage= new SearchPage(driver);
        searchPage.getsearch(arg1);
        searchPage.search_click();

        //driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys(arg1);
        //driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
    }

    @Then("{string} results are display")
    public void results_are_display(String arg) {
        Assert.assertTrue(searchPage.showresult1().getText().contains(arg));
        //Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Shirt']")).getText().contains(arg));

    }
    @Then("{string} results are display on page")
    public void results_are_display_on_page(String dress) {
        Assert.assertTrue(searchPage.showresult2().getText().contains(dress));
        //Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dress']")).getText().contains(dress));
    }
    @Then("user select brand and dress")
    public void user_select_brand_and_dress() {

        List<WebElement> listElement = driver.findElements(By.xpath("//ul[@class='brand-list']/li/label"));
        listElement.get(1).click();
        for(int i =0;i<listElement.size();i++) {
            String elementText = listElement.get(i).getText();
            System.out.println(elementText);
        }
    }
    @Then("User proceeded to ckeckout page for perchess")
    public void user_proceeded_to_ckeckout_page_for_perchess() {
        List<WebElement> manydress = driver.findElements(By.xpath("//a[@target='_blank']"));
        manydress.get(2).click();
        //String mainWindow =driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        String mainwindow = iterator.next();
        String ChildWindow = iterator.next();
        driver.switchTo().window(ChildWindow);
        // List<WebElement> size = driver.findElements(By.xpath("//div[@class='size-buttons-size-buttons']"));
        //size.get(1).click();
        driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();
        //driver.switchTo().window(ChildWindow);
    }


//    @Then("Verify select {string} item is display on ckechout page")
//    public void verify_select_item_is_display_on_ckechout_page(String string) {
//        Assert.assertTrue(driver.findElement(By.cssSelector("p.product-name")).getText().contains(string));
//    }
}