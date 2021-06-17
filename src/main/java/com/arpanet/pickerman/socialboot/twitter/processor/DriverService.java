package com.arpanet.pickerman.socialboot.twitter.processor;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class DriverService implements ApplicationRunner {

    public static ChromeDriver driver;
//  public static FirefoxDriver driver;
    public static WebDriverWait wait;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //driver = new FirefoxDriver();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; AS; rv:11.0) like Gecko");

        //options.addArguments("--start-maximized");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);


        driver.get("https://twitter.com/login");

        /*
        String parent_window = driver.getWindowHandle();
        System.out.println("Parent Window Handle is: "+driver.getWindowHandle());
        System.out.println("Page Title is: "+driver.getTitle());
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com/');");
        new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindows_1 = driver.getWindowHandles();
        System.out.println("Total Windows: "+allWindows_1.size());
        for(String hand1:allWindows_1)
            if(!parent_window.equals(hand1))
            {
                driver.switchTo().window(hand1);
                new WebDriverWait(driver,10).until(ExpectedConditions.titleContains("Facebook"));
                String first_child_window = driver.getWindowHandle();
                System.out.println("First Child Window Handle is: "+first_child_window);
                System.out.println("First Child Window Page Title is: "+driver.getTitle());
                driver.close();
            }
        driver.switchTo().window(parent_window);
        System.out.println("Current Window Handle is : "+driver.getWindowHandle()+ " which is same as "+parent_window +", which is the parent window handle" );
*/
        
/*
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[1]")));

        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        WebElement username = driver.findElement(By.name("session[username_or_email]"));
        WebElement password = driver.findElement(By.name("session[password]"));
        WebElement login = driver.findElement(By.xpath("//div[@data-testid='LoginForm_Login_Button']"));

        username.sendKeys("beyzain34499544");
        password.sendKeys("beyza0600");
        login.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");

        Thread.sleep(500);
        Thread.sleep(10 * 1000);

        WebElement tweet = driver.findElement(By.xpath("//div[@data-testid='tweetTextarea_0']"));
        tweet.sendKeys("seldfvggg");

        WebElement tweet_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetButtonInline']")));
        tweet_button.click();
        Thread.sleep(5000);

        WebElement replyCount = driver.findElement(By.xpath(".//div[@data-testid='reply']"));

        replyCount.click();
        Thread.sleep(3000);
        //WebElement retweetCount =driver.findElement(By.xpath(".//div[@data-testid='retweet']"));
        WebElement reply = driver.findElement(By.xpath("//div[@data-testid='tweetTextarea_0']"));
        reply.sendKeys("dendcfvfbg");
        WebElement reply_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetButton']")));
        reply_button.click();
        Thread.sleep(4000);

        //Thread.sleep(10 * 1000);
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div[1]/div/div/article")));
        WebElement likeCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@data-testid='like']")));
        likeCount.click();
        Thread.sleep(4000);

        WebElement retweet_button = driver.findElement(By.xpath(".//div[@data-testid='retweet']"));
        // //div[@data-testid='Retweet']
        //"//div[@aria-label="0 Retweets.Retweet']"
        retweet_button.click();
        Thread.sleep(3000);
        WebElement retweet_confirm = driver.findElement(By.xpath(".//div[@data-testid='retweetConfirm']"));
        retweet_confirm.click();
        Thread.sleep(1000);

 */
        /*
        WebElement pintweet = driver.findElement(By.xpath( ".//div[@data-testid='confirmationSheetCancel']"));
        pintweet.click();
        Thread.sleep(1000);

         */

        /*
        WebElement points = driver.findElement(By.xpath(".//div[@data-testid='caret']"));
        points.click();

        WebElement delete = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div[1]"));
        delete.click();
        Thread.sleep(2000);
        WebElement dltbtn = driver.findElement(By.xpath(".//div[@data-testid='confirmationSheetConfirm']"));
        dltbtn.click();
        Thread.sleep(3000);

        driver.get("https://twitter.com/logout");

        WebElement logout = driver.findElement(By.xpath(".//div[@data-testid='confirmationSheetConfirm']"));
        logout.click();




         */

        /*

        //Wait and Click Logout Button
        WebElement account = driver.findElement(By.xpath( ".//div[@data-testid='SideNav_AccountSwitcher_Button']"));
        account.click();
        Thread.sleep(3000);

        WebElement logout = driver.findElement(By.xpath( ".//*[@id=\"layers\"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/a[2]"));
        ////*[@id="layers"]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/a[2]
        //.//div[@data-testid='AccountSwitcher_Logout_Button']
        logout.click();

         */
        /*
        Thread.sleep(10 * 1000);

        driver.close();
        driver.quit();

         */
        /*
        public void like(ApplicationArguments args) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@data-testid='tweet']")));
        WebElement tweets=driver.findElement(By.xpath("//div[@data-testid='tweet']");

        for (int i = 0; i < tweets.length(); i++){
            like= driver.findElement(By.xpath("//div[@data-testid='like']")).click();
            likes -= 1;
            Thread.sleep(3000);

        }
        */
/*

        WebElement bottomDiv = tweet.findElement(By.className("stream-item-footer"));
        String reply = bottomDiv.findElement(
                By.cssSelector("button.ProfileTweet-actionButton.js-actionButton.js-actionReply"))
                .findElement(By.className("ProfileTweet-actionCountForPresentation")).getText();

        String reTweet = bottomDiv
                .findElement(
                        By.cssSelector("button.ProfileTweet-actionButton.js-actionButton.js-actionRetweet"))
                .findElement(By.className("ProfileTweet-actionCountForPresentation")).getText();
        String like = bottomDiv
                .findElement(
                        By.cssSelector("button.ProfileTweet-actionButton.js-actionButton.js-actionFavorite"))
                .findElement(By.className("ProfileTweet-actionCountForPresentation")).getText();

        if (!like.isEmpty()) {
            tweet.setLike(like);
        }
        if (!reply.isEmpty()) {
            tweet.setReply(reply);
        }
        if (!reTweet.isEmpty()) {
            tweet.setReTweet(reTweet);
        }
        return tweet;
        */


    }
}

