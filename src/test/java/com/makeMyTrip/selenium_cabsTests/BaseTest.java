package com.makeMyTrip.selenium_cabsTests;

import org.testng.annotations.AfterMethod;
import java.awt.image.BufferedImage;
import java.time.Duration;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseTest {
	public RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	Actions actions = null;
	
	//TC_Cab_003
	
	@BeforeMethod
	public void CabsButtonClickTest() throws IOException {
		driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
		driver.get("https://www.makemytrip.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		driver.findElement(By.xpath("//li[@class=\"menu_Cabs\"]")).click();
		driver.manage().window().maximize();	
	}
	
	
    public void tearDown() {
        if (driver != null) driver.quit();
    }
	
	
}

/*AShot ashot = new AShot();
ashot.shootingStrategy(ShootingStrategies.viewportPasting(4000)).takeScreenshot(driver);
Screenshot sc = ashot.takeScreenshot(driver);
BufferedImage img = sc.getImage();
ImageIO.write(img, "png", new File("usingAsot.png"));
*/
