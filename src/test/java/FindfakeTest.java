import com.fa925.DriverConfig;
import com.fa925.Findfake;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class FindfakeTest {
    private Findfake fakeFinder;
    private WebDriver driver;

    @Before
    public void setup(){
        driver = new DriverConfig().configDriver();
        fakeFinder = new Findfake(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Verify that you're on the proper webpage")
    public void checkPageTitle(){
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
        String pageTitle = driver.getTitle();

        Assert.assertEquals("React App",pageTitle);
    }

    @Test
    @DisplayName("Check for weigh and reset buttons on webpage")
    public void testMainButtons(){
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
        String weighButtonText = driver.findElement(By.xpath("//button[@id='weigh']")).getText();
        String resetButtonText = driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).getText();

        Assert.assertEquals("Weigh",weighButtonText);
        Assert.assertEquals("Reset",resetButtonText);
    }

    @Test
    @DisplayName("Check that nine bars are present")
    public void checkBarCount(){
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
        List coinList = driver.findElements(By.xpath("//button[contains(@id,'coin_')]"));

        Assert.assertEquals(9,coinList.size());
    }

    @Test
    @DisplayName("Check that a left and right bowl are present")
    public void checkBowls(){
        driver.get("http://ec2-54-208-152-154.compute-1.amazonaws.com/");
        boolean rightBowl = driver.findElement(By.xpath("//input[@data-side='right']")).isDisplayed();
        boolean leftBowl = driver.findElement(By.xpath("//input[@data-side='left']")).isDisplayed();

        Assert.assertTrue(rightBowl);
        Assert.assertTrue(leftBowl);
    }

}
