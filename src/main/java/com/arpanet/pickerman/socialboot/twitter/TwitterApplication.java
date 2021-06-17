package com.arpanet.pickerman.socialboot.twitter;

import com.arpanet.pickerman.socialboot.twitter.service.BootUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@EnableScheduling
@SpringBootApplication
@EnableMongoRepositories
public class TwitterApplication implements CommandLineRunner{


    @Autowired
    private BootUserService bootUserService;
    //private  UserRepository userRepository;


    @Value("${my-variable.name}")
    private String myName;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator +"chromedriver");
//        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator +"chromedriver");
        //System.setProperty("/usr/local/Cellar/geckodriver/0.29.0")
        SpringApplication.run(TwitterApplication.class, args);

    }



    @Override
    public void run(String... args) throws Exception {

//        User user = new User();
//        user.setDisplayName("Beyza");
//        user.setPassword("beyza0600");
//        user.setTelNo(2147483648L);
//
//        user.setEmail("beyzaa0204gmail.com");
//        user.setUsername("beyz_ince");
//        userService.save(user);
           //System.out.println("My name is: " + myName);
          //List<User> listofUser= new ArrayList<User>();
          /*
        User user = new User();
          user.setDisplayName("Beyzoş");
          user.setPassword("Beyza0204");
          user.setTelNo(05315239006L);

          user.setEmail("beyzaa0204gmail.com");
          user.setUsername("beyzo50615160");
          userService.save(user);
       /*

        User user = new User();
        user.setId(2L);
        user.setName("Beyza");
        user.setPassword("Sana ne?");
        user.setTelNo(2147483648L);

        user.setEmail("beyzaa0204qmail.com");
        user.setUser("beyzos");
        listofUser.add(user);

        User user1 = new User();
        user1.setId(2L);
        user1.setName("Betül");
        user1.setPassword("Sanane?");
        user1.setTelNo(5074122530L);
        user1.setEmail("betülinceqmail.com");
        user1.setUser("betüs");
        listofUser.add(user1);
        System.out.println("***************");
        userService.insert(listofUser);*/


        //List<User> users =userService.getAll();
        //for(User u:users){
            //System.out.println(u.toString());
            //System.out.println(u.getName());

        //User user = userService.getById(2L);
        //System.out.println(user);


        //for(User u: userService.getAll()){
        //System.out.println(u.getName());
                //}

            //}

        }
    }










