package fbt.tests;

import org.junit.Test;

public class MainPageTest extends BaseTest{
    @Test
    public void isMainPageLoaded(){
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
    }
    @Test
    public void checkMoreButtonInTheLeftOfThePage() throws Exception {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.checkTheMoreButton();
        Thread.sleep(500);
        takeSnapShot(driver,".//screenshot/showingtheleftpanel.png");
    }
    @Test
    public void isLeftListUrlWorks() throws InterruptedException {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.checkTheMoreButton();
        Thread.sleep(500);
        mainPage.checkLeftList();
    }
    @Test
    public void IsSearchBarWorking() throws Exception {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.isSearchBarWorks();
        takeSnapShot(driver,".//screenshot/searchbar.png");
    }
    @Test
    public void AreLinksOnTheTopWorking(){
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.linksOnTheTopWork();
    }
    @Test
    public void AreHudButtonsWorking() throws Exception {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.hubButtonsWork();
        takeSnapShot(driver,".//screenshot/hudbuttons.png");
    }
}
