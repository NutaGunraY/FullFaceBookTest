package JustAPackage;

import JustAPackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddUserPage extends BasePage {
    List<WebElement> addUserPage;
    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_n9']//div[@class='_n3']//div[@class='_8ien']"))).isDisplayed();
    }

    public void fillTheData(String name, String surname, String emailOrPhone, String password){
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(surname);
        driver.findElement(By.name("reg_email__")).sendKeys(emailOrPhone);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(emailOrPhone);
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
    }

    public void selectTheData(String dd, String mm, String yyyy) {
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByVisibleText(dd);
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByVisibleText(mm);
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText(yyyy);
    }

    public void selectGender(String gender) {
        if(gender == "Women") {
            driver.findElement(By.xpath("(//label[@class='_58mt'])[1]")).click();
        }else if(gender == "Man"){
            driver.findElement(By.xpath("(//label[@class='_58mt'])[2]")).click();
        }else if(gender == "Other"){
            driver.findElement(By.xpath("(//label[@class='_58mt'])[3]")).click();
        }
    }

    public void submitRegistration() {
        driver.findElement(By.name("websubmit")).click();
    }
}
