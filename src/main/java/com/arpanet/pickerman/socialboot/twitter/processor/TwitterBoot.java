package com.arpanet.pickerman.socialboot.twitter.processor;

import com.arpanet.pickerman.socialboot.twitter.document.*;
import com.arpanet.pickerman.socialboot.twitter.document.struct.PostOperationType;
import com.arpanet.pickerman.socialboot.twitter.document.struct.UserOperationType;
import com.arpanet.pickerman.socialboot.twitter.service.BootUserService;
import com.arpanet.pickerman.socialboot.twitter.service.PostOperationService;
import com.arpanet.pickerman.socialboot.twitter.service.UserOperationService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

import static com.arpanet.pickerman.socialboot.twitter.document.struct.PostOperationType.*;
import static com.arpanet.pickerman.socialboot.twitter.document.struct.UserOperationType.LOGIN;
import static com.arpanet.pickerman.socialboot.twitter.document.struct.UserOperationType.LOGOUT;
import static com.arpanet.pickerman.socialboot.twitter.processor.DriverService.driver;
import static com.arpanet.pickerman.socialboot.twitter.processor.DriverService.wait;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TwitterBoot extends Boot {

    final private BootUser bootUser;
    final private BootUserService bootUserService;
    final private UserOperationService userOperationService;
    final private PostOperationService postOperationService;

    public TwitterBoot(BootUser bootUser, BootUserService bootUserService, UserOperationService userOperationService, PostOperationService postOperationService) {
        this.bootUser = bootUser;
        this.bootUserService = bootUserService;
        this.userOperationService = userOperationService;
        this.postOperationService = postOperationService;
    }


    private void savePostOperation(PostOperationType postOperationType, TwitterPost post) {
        PostOperation postOperation = new PostOperation();
        postOperation.setPostOperationType(postOperationType);
        postOperation.setCreateDate(new Date());
        postOperation.setBootUser(bootUser);
        postOperation.setPost(post);
        postOperationService.save(postOperation);
    }
    private void saveUserOperation(UserOperationType userOperationType, TwitterUser effectedUser) {
        UserOperation userOperation = new UserOperation();
        userOperation.setUserOperationType(userOperationType);
        userOperation.setCreateDate(new Date());
        userOperation.setBootUser(bootUser);
        userOperation.setEffectedUser(effectedUser);
        userOperationService.save(userOperation);
    }

    @Override
    void like() throws InterruptedException {
        //System.out.println("Like from twitter");
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div[1]/div/div/article")));
        WebElement like= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@data-testid='like']")));
        like.click();
        //Thread.sleep(4000);
        savePostOperation(LIKE, new TwitterPost());
    }

    @Override
    void tweet() throws InterruptedException {
        //System.out.println(" twitted");
        WebElement tweet = driver.findElement(By.xpath("//div[@data-testid='tweetTextarea_0']"));
        tweet.sendKeys();
        WebElement tweet_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetButtonInline']")));
        tweet_button.click();
        //Thread.sleep(5000);
        savePostOperation(TWEET, new TwitterPost());

    }

    @Override
    void retweet() throws InterruptedException {
        WebElement retweet_button = driver.findElement(By.xpath(".//div[@data-testid='retweet']"));
        retweet_button.click();
        //Thread.sleep(3000);
        WebElement retweet_confirm = driver.findElement(By.xpath(".//div[@data-testid='retweetConfirm']"));
        retweet_confirm.click();
        //Thread.sleep(1000);
        //System.out.println(" retweeted");
        savePostOperation(RETWEET, new TwitterPost());



    }

    @Override
    void reply() throws InterruptedException {
        countLike();
        //System.out.println("reply from twitter");
        WebElement replyCount = driver.findElement(By.xpath(".//div[@data-testid='reply']"));
        replyCount.click();
        //Thread.sleep(3000);
        WebElement reply = driver.findElement(By.xpath("//div[@data-testid='tweetTextarea_0']"));
        reply.sendKeys();
        WebElement reply_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetButton']")));
        reply_button.click();
        //Thread.sleep(4000);

        savePostOperation(REPLY, new TwitterPost());

    }

    @Override
    void delete() throws InterruptedException {
        //System.out.println("deleted");
        WebElement points = driver.findElement(By.xpath(".//div[@data-testid='caret']"));
        points.click();

        WebElement delete = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div[1]"));
        delete.click();
        //Thread.sleep(2000);
        WebElement dltbtn = driver.findElement(By.xpath(".//div[@data-testid='confirmationSheetConfirm']"));
        dltbtn.click();
        //Thread.sleep(3000);
        savePostOperation(DELETE, new TwitterPost());
    }

    @Override
    void account() throws InterruptedException


    {
        //System.out.println("account");
        driver.get("https://twitter.com/i/flow/signup");
        //WebElement login = driver.findElement(By.xpath("//div[@data-testid='signupButton']"));
        Thread.sleep(1000000);


        WebElement mail= driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[4]"));
        //WebElement mail=driver.findElementByXPath("//*[text() = 'Use email instead']");
        //WebElement mail= driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[4]/span"));

        mail.click();

        Thread.sleep(3000);
        WebElement nameE = driver.findElement(By.name("name"));

        WebElement emailE = driver.findElement(By.name("email"));
        emailE.sendKeys(bootUser.getEmail());
        nameE.sendKeys(bootUser.getTwitterUser().getScreenName());





        //WebElement ayE = driver.findElement(By.id("Month"));
        /*
        Select Month=new Select(driver.findElement(By.id("Month")));
        Month.selectByVisibleText("10");
        Thread.sleep(3000);
        boolean status=Month.getOptions();
        if(status){
            for( int i=0; i<10; i++){
                Month.selectByIndex(i);

            }
        }
            else{
                System.out.println("yetersdfgbhnj");
            }
            */



        //WebElement ayE = driver.findElement(By.id("Ay"));
        //WebElement gunE = driver.findElement(By.id("Day"));
        //WebElement yilE = driver.findElement(By.id("Year"));
        /*
        WebElement dateWidget = driver.findElement(By.xpath("//*[@id='Month']"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            //Select 13th Date
            if (cell.getText().equals("13")) {
                cell.findElement(By.linkText("13")).click();
                break;
            }
        }



        /*
        Select select = new Select(driver.findElement(By.xpath("//*[@id='Month']")));
        //get all the selected options of the dropdown
        List<WebElement> lst=select.getOptions();
        System.out.println("the dropdown options are");
        for(WebElement options:lst)
            System.out.println(options.getText());
        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);
        System.out.println("Select value is: " + select.getAllSelectedOptions());
        //------------------------

        // Select the option by index
        //se.selectByIndex(3);

        gunE.sendKeys(gun);
        ayE.sendKeys(ay);
        //yilE.sendKeys(yil);

         */

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[2]/div[1]/div/div/div/div[3]/div")));
        //next.click();

        Thread.sleep(1000);
        WebElement next = driver.findElementByXPath("//*[text() = 'Next']");
        next.click();
        Thread.sleep(1000);
        WebElement next2 = driver.findElementByXPath("//*[text() = 'Next']");
        next2.click();
        Thread.sleep(1000);
        WebElement signupBtn = driver.findElementByXPath("//*[text() = 'Sign up']");
        signupBtn.click();

        driver.executeScript("window.open('about:blank','secondtab')");
        driver.switchTo().window("secondtab");


        //new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("password");
        //driver.findElement(By.id("passwordNext")).click();


        driver.get("https://accounts.google.com/signin");
        WebElement accounts=driver.findElementByName("identifier");
        accounts.sendKeys("beyzaa0204@gmail.com");
        //new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("emailID");
        //driver.findElement(By.id("identifierNext")).click();
        WebElement step=driver.findElementByXPath("//*[@id=\"identifierNext\"]/div/button");
        //WebElement step = driver.findElementByXPath("//*[text() = 'İleri']");
        step.click();
        WebElement pass=driver.findElementByName("password");
        pass.sendKeys("beyza0600");
        WebElement step2 = driver.findElement(By.id("identifierNext"));;
        step2.click();
        WebElement twitter=driver.findElementByName("Twitter");
        twitter.click();

        BootUser bootUser=new BootUser();

        bootUserService.account(bootUser);

    }

    private void selectDate(String month_year, String day) {
    }

    @Override
    void logout() {
        driver.get("https://twitter.com/logout");
        WebElement logout = driver.findElement(By.xpath(".//div[@data-testid='confirmationSheetConfirm']"));
        logout.click();
        saveUserOperation(LOGOUT, bootUser.getTwitterUser());

    }

    @Override
    public void start() throws InterruptedException {
        System.out.println("start twitter boot");
        login();
        Thread.sleep(2000);

        //like();
        Thread.sleep(4000);
        //tweet();
        Thread.sleep(4000);
        //reply();
        Thread.sleep(4000);
        //delete();
        Thread.sleep(4000);
        //retweet();
        Thread.sleep(4000);
        //logout();
        Thread.sleep(4000);
        account();
        Thread.sleep(4000);

        System.out.println(String.format("You have %d like",countLike()));
    }



    @Override
    void login() throws InterruptedException {
        System.out.println(String.format("your name is %s your password is %s", bootUser.getUsername(), bootUser.getPassword()));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[1]")));

        Thread.sleep(1000);
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        WebElement usernameE = driver.findElement(By.name("session[username_or_email]"));
        WebElement passwordE = driver.findElement(By.name("session[password]"));
        WebElement login = driver.findElement(By.xpath("//div[@data-testid='LoginForm_Login_Button']"));

        usernameE.sendKeys(bootUser.getUsername());
        passwordE.sendKeys(bootUser.getPassword());
        login.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, Math.max(document.documentElement.scrollHeight, document.body.scrollHeight, document.documentElement.clientHeight));");

        Thread.sleep(500);

        saveUserOperation(LOGIN, bootUser.getTwitterUser());


    }
}
