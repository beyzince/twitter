package com.arpanet.pickerman.socialboot.twitter.controller;

import com.arpanet.pickerman.socialboot.twitter.document.BootUser;

import com.arpanet.pickerman.socialboot.twitter.service.BootUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;


import java.util.List;

@RestController
@Component
@RequestMapping(value="/User")
public class TestController {

    @Autowired
    private BootUserService bootUserService;


    @GetMapping(value ="/all")
    //public List<User> getAllUser(){
    public ResponseEntity<List<BootUser>>getAllUser(){
        return  new ResponseEntity<List<BootUser>>(bootUserService.getAll(),HttpStatus.OK);


        //return userService.getAll();
    }


    @PutMapping(value = "/update")
    public BootUser updateUser(@RequestBody BootUser usr){
        return bootUserService.updateUser(usr);


    }
    //@DeleteMapping("/{id}")
    //public void delete(@RequestParam("id") Long id){
        //userService.delete(id);

    //}
    @GetMapping("/test/account")
    //public void account(@RequestParam String name, @RequestParam String email,@RequestParam String ay,@RequestParam String gun,@RequestParam String yil) throws InterruptedException
    public BootUser account(@RequestBody BootUser bootUser) throws InterruptedException
    {
        return bootUserService.account(bootUser);



    }

    @GetMapping("/test/login")
    public void login(@RequestParam String username, @RequestParam String password) throws InterruptedException {
    }

    @GetMapping("test/tweet")
    public void tweet(@RequestParam String msg) throws InterruptedException {
        /*

        WebElement tweet = driver.findElement(By.xpath("//div[@data-testid='tweetTextarea_0']"));
        tweet.sendKeys(msg);
        WebElement tweet_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetButtonInline']")));
        tweet_button.click();
        Thread.sleep(5000);
        */


    }

    @GetMapping("test/reply")
    public void reply(@RequestParam String msg) throws InterruptedException {
        /*
        WebElement replyCount = driver.findElement(By.xpath(".//div[@data-testid='reply']"));
        replyCount.click();
        Thread.sleep(3000);
        WebElement reply = driver.findElement(By.xpath("//div[@data-testid='tweetTextarea_0']"));
        reply.sendKeys(msg);
        WebElement reply_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='tweetButton']")));
        reply_button.click();
        Thread.sleep(4000);

         */
    }

    @GetMapping("test/like")
    public void like() throws InterruptedException {
        /*
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[4]/div/div/section/div/div/div[1]/div/div/article")));
        WebElement like= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@data-testid='like']")));
        like.click();
        Thread.sleep(4000);*/
    }

    @GetMapping("test/retweet")
    public void retweet() throws InterruptedException {
        /*
        WebElement retweet_button = driver.findElement(By.xpath(".//div[@data-testid='retweet']"));
        retweet_button.click();
        Thread.sleep(3000);
        WebElement retweet_confirm = driver.findElement(By.xpath(".//div[@data-testid='retweetConfirm']"));
        retweet_confirm.click();
        Thread.sleep(1000);

         */
    }
    @GetMapping("test/delete")
    public void delete() throws InterruptedException{
    //@DeleteMapping("test/delete"){
    //public ResponseEntity<?> deleteById()//@PathVariable long twitterId){
        //try{
            //userService.delete(twitterId);
            //return new ResponseEntity<>("successfuly delted with twitter ıd"+twitterId , HttpStatus.OK);
        //}catch(Exception e){
            //return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        }


        /*
        WebElement points = driver.findElement(By.xpath(".//div[@data-testid='caret']"));
        points.click();

        WebElement delete = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div[2]/div[3]/div/div/div/div[1]"));
        delete.click();
        Thread.sleep(2000);
        WebElement dltbtn = driver.findElement(By.xpath(".//div[@data-testid='confirmationSheetConfirm']"));
        dltbtn.click();
        Thread.sleep(3000);

         */


    @GetMapping("test/logout")
    public void logout() throws InterruptedException {
        /*
        driver.get("https://twitter.com/logout");
        WebElement logout = driver.findElement(By.xpath(".//div[@data-testid='confirmationSheetConfirm']"));
        logout.click();

         */
    }


}

