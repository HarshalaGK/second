package com.myntra.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
      protected WebDriver driver;
    public SearchPage(WebDriver driver){ this.driver=driver; }

     By searchbox = By.xpath("//input[@id='searchAll']");
     By searchbox_click=By.xpath("//button[@type='submit']");
     By shirtresult = By.xpath("//h1[text()='shirt']");
     By dressResult=By.xpath("//h1[text()='dress']");

public void getsearch(String text)

{
 driver.findElement(searchbox).sendKeys(text);
}
public void search_click()

{
     driver.findElement(searchbox_click).click();
}
public WebElement showresult1(){

     return driver.findElement(shirtresult);
}
    public WebElement showresult2(){
        return driver.findElement(dressResult);
    }
}

