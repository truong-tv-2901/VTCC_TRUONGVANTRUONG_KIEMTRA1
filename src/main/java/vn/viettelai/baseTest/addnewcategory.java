package vn.viettelai.baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


public class addnewcategory extends baseTest{
    @Test
    public void AddnewCategory(){
        // driver.findElement(By.className("aiz-mobile-toggler")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        WebElement verifyTitle = driver.findElement(By.xpath("(//h1[normalize-space()='All categories'])[1]"));
        Assert.assertTrue(verifyTitle .isDisplayed());
//        Assert.assertEquals(verifyTitle.getAttribute("value").trim().toString(), "All Categories");
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
    }
    @Test
    public void TestName(){
        driver.findElement(By.xpath("(//input[@id='name'])[1]")).sendKeys("Sushi");

    }
    @Test
    public void ParentCate(){

        driver.findElement(By.xpath("//div[contains(text(),'No Parent')]")).click();

        driver.findElement(By.xpath("(//div[@class='bs-searchbox'])[1]")).sendKeys("Laptop");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();

    }
    @Test
    public void OrderLevel(){

        driver.findElement(By.id("order_level")).sendKeys("12345");
    }

    @Test
    public void TestType(){
        Select select = new Select(driver.findElement(By.name("digital")));
        select.selectByIndex(1);
    }

    @Test
    public void TestMetaTitle(){
        driver.findElement(By.xpath("(//input[@placeholder='Meta Title'])[1]")).sendKeys("VTCC");

    }
    @Test
    public void TestMetaDes(){
        driver.findElement(By.xpath("(//textarea[@name='meta_description'])[1]")).sendKeys("Trung tâm trí tuệ nhân tạo");

    }

    @Test
    public void TestAttributes(){

        driver.findElement(By.xpath("(//button[@title='Nothing selected'])[1]")).click();

        driver.findElement(By.xpath("(//input[@aria-label='Search'])[2]")).sendKeys("Fabric");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    @Test
    public void ButtonSave(){
        driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
    }

      @Test
    public void VefifyResult(){
        WebElement Search_cate = driver.findElement(By.id("search"));
        Search_cate.sendKeys("Sushi");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.RETURN);
        action.perform();
        WebElement Result = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(Result.getText().contains("Sushi"));
    }



}
