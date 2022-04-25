package fbt.tests;

import JustAPackage.AddUserPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


import static org.junit.Assert.assertTrue;

public class CreateTheNewUserTest extends BaseTest{
    AddUserPage addUserPage;
    @Before
    public void clickTheAddUserButton(){
        driver.findElement(By.xpath("//a[@role='button'][@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        addUserPage = new AddUserPage(driver);
        assertTrue(addUserPage.isLoaded());
    }
    @Test
    public void fillTheMainData(){
        addUserPage = new AddUserPage(driver);
        assertTrue(addUserPage.isLoaded());
        addUserPage.fillTheData("Nick","Jackson","marioGo@gmail.com","simpleSaucePassword1");
        addUserPage.selectTheData("21","апр","1999");
        addUserPage.selectGender("Man");
        addUserPage.submitRegistration();
    }
}
