package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataProviderTest {

    @DataProvider(parallel = true)
    public Object[][] simpleDataprovider() {
        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1 , "To be flexible and\n" +
                        "customizable"},
                {2 , "To be multiplatform"},
                {3 , "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };

    }

    @Test(dataProvider = "simpleDataprovider")
    public void dataProviderTest(int elementNumber, String assertText) {

        //1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        List<WebElement> iconElemnts = driver.findElements(By.className("benefit-txt"));


        System.out.println(elementNumber);
        Assert.assertEquals(iconElemnts.get(elementNumber).getText(), assertText);
        driver.close();
    }
}
