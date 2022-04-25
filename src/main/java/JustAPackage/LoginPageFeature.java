package JustAPackage;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



import java.util.List;

import static io.restassured.RestAssured.get;


public class LoginPageFeature extends BasePage{

    private By passwordFeature = By.id("pass");
    public LoginPageFeature(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get("https://www.facebook.com/");
    }
    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).isDisplayed();
    }


    public void login(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(passwordFeature).sendKeys(password);
        driver.findElement(By.name("login")).click();
    }

    public boolean isPasswordButtonVisible() {
        driver.findElement(passwordFeature).sendKeys("1");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._9lsa"))).isDisplayed();
    }

    public boolean isPasswordVisible() {
        driver.findElement(By.cssSelector("._9lsa")).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']"))).isDisplayed();

    }

    public boolean iSCreateButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@role='button'][@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"))).isDisplayed();
    }

    public boolean forgotButtonIsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_6ltj']//a"))).isDisplayed();
    }

    public void checkingTheRecoverPage() {
        WebElement link = driver.findElement(By.xpath("//div[@class='_6ltj']//a"));
        String url = link.getAttribute("href");
        response = get(url);
        int status = response.getStatusCode();
        if(status == 200){
            System.out.println(status + " Recover password Page is working OK");
        }
    }

    public void checkTheURLs() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='pageFooterChildren']//ul//li/a"));
        System.out.println("Amount of links: " + links.size());
        for(int i =0; i<links.size();i++){
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            System.out.println(url);
            response = get(url);
            int status = response.getStatusCode();
            try {
                if(status == 200) {
                    System.out.println(status + ": IS OK");
                }else{
                    System.out.println(status + " IS NOT OK");
                }

            }catch(Exception e){
            }
        }
    }

    /*public void checkTheURLs() {
        /*List<WebElement> links = driver.findElements(By.xpath("//div[@id='pageFooterChildren']//ul//li/a[@href]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(WebElement link : links){
            link.click();
            System.out.println(driver.getCurrentUrl());
            System.out.println("||||||||||||||||||||||||||||||");
            driver.navigate().back();
        }
        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.xpath("//div[@id='pageFooterChildren']//ul//li/a"));

        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());

        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            //verifyLinks(url);
            System.out.println(url);

        }

        driver.quit();
    }
       public static void verifyLinks(String linkUrl)
        {
            try
            {
                URL url = new URL(linkUrl);

                //Now we will be creating url connection and getting the response code
                HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
                httpURLConnect.setConnectTimeout(5000);
                httpURLConnect.connect();
                if(httpURLConnect.getResponseCode()>=400)
                {
                    System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
                }

                //Fetching and Printing the response code obtained
                else{
                    System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
                }
            }catch (Exception e) {
            }
    }*/
}
