package finalProject;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AmazonGiftCards extends Parameters {
    WebDriver driver = new ChromeDriver();
	SoftAssert myAssertion = new SoftAssert();

    @BeforeTest
    public void myBeforeTest() {
        driver.get(myUrl);

        driver.manage().window().maximize();
        driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void RandomGiftCard () throws InterruptedException {
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        WebElement giftCardContainer = driver.findElement(By.className("a-carousel"));
        List<WebElement> giftCards = giftCardContainer.findElements(By.className("a-spacing-mini"));

        int randomIndex = random.nextInt(giftCards.size());
        giftCards.get(randomIndex).click();


    }
    @Test (priority = 2)
    public void RandomPriceAmount () throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        WebElement amountContainer = driver.findElement(By.cssSelector("#gc-amount-mini-picker"));
        List<WebElement> priceAmounts = amountContainer.findElements(By.className("a-button-text"));

   int priceIndex = randomAmount.nextInt(priceAmounts.size());
        priceAmounts.get(priceIndex).click();
        
        String expectedMessage = driver.findElement(By.cssSelector(".a-color-price.a-text-bold")).getText();
        String ActualMessage = driver.findElement(By.id("gc-live-preview-amount")).getText();
        System.out.println(expectedMessage);
       myAssertion.assertEquals(ActualMessage, expectedMessage, "price don't match");
       myAssertion.assertAll();
    }
    @Test (priority = 3)
    public void fillAllBlank () throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 

    	WebElement NameInput = driver.findElement(By.id("gc-order-form-senderName"));
		WebElement EmailInput = driver.findElement(By.id("gc-order-form-recipients"));
		WebElement randomMessege = driver.findElement(By.id("gc-order-form-message"));
		WebElement randomQuantity = driver.findElement(By.id("gc-order-form-quantity"));

		driver.findElement(By.id("gc-order-form-date-val")).click();
		driver.findElement(By.xpath("//a[normalize-space()='24']")).click();
		
		NameInput.sendKeys(Name);
		randomMessege.clear();
		randomMessege.sendKeys(RandomInputMessage);
		EmailInput.sendKeys(Email);
		randomQuantity.clear();
		randomQuantity.sendKeys(randomQuantityString);
		
    }
    @AfterTest
    public void myAfterTest() {
        
    }
}
