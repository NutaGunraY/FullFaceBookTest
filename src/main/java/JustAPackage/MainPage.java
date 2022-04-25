package JustAPackage;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static io.restassured.RestAssured.get;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='main']"))).isDisplayed();
    }

    public void checkTheMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)"))).click();
    }

    public void checkLeftList() {
        List<WebElement> links = driver.findElements(By.xpath("(//ul)[3]/li/div/a"));
        System.out.println("Amount of links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            System.out.println(url);
            response = get(url);
            int status = response.getStatusCode();
            try {
                if (status == 200) {
                    System.out.println(status + ": IS OK");
                } else {
                    System.out.println(status + " IS NOT OK");
                }

            } catch (Exception e) {
            }
        }
    }

    public void isSearchBarWorks() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='rq0escxv byvelhso q10oee1b poy2od1o j9ispegn kr520xx4 ooia0uwo kavbgo14 mhnrfdw6'] div label[class='lzcic4wl gs1a9yip br7hx15l h2jyy9rg n3ddgdk9 owxd89k7 rq0escxv j83agx80 a5nuqjux l9j0dhe7 k4urcfbm kbf60n1y b3i9ofy5']"))).sendKeys("Something that i want");
    }

    public void linksOnTheTopWork() {
        List<WebElement> links = driver.findElements(By.xpath("(//ul[@class='thodolrn ojvp67qx taijpn5t buofh1pr j83agx80 aovydwv3 bqdfd6uv'])/li/span/div/a"));
        System.out.println("Amount of links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            System.out.println(url);
            response = get(url);
            int status = response.getStatusCode();
            try {
                if (status == 200) {
                    System.out.println(status + ": IS OK");
                } else {
                    System.out.println(status + " IS NOT OK");
                }

            } catch (Exception e) {
            }
        }
    }

    public void hubButtonsWork() {
        driver.findElement(By.xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[3]")).click();
        driver.findElement(By.xpath("(//span[@class='tojvnm2t a6sixzi8 abs2jz4q a8s20v7p t1p8iaqh k5wvi7nf q3lfd5jv pk4s997a bipmatt0 cebpdrjk qowsmv63 owwhemhu dp1hu0rb dhp61c6y iyyx5f41'])[7]")).click();
    }
}