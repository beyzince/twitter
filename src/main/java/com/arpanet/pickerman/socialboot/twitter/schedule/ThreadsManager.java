package com.arpanet.pickerman.socialboot.twitter.schedule;

import com.arpanet.pickerman.socialboot.twitter.document.BootUser;
import com.arpanet.pickerman.socialboot.twitter.processor.Boot;
import com.arpanet.pickerman.socialboot.twitter.processor.TwitterBoot;
import com.arpanet.pickerman.socialboot.twitter.service.BootUserService;
import com.arpanet.pickerman.socialboot.twitter.service.PostOperationService;
import com.arpanet.pickerman.socialboot.twitter.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadsManager {

    final private BootUserService bootUserService;
    final private UserOperationService userOperationService;
    final private PostOperationService postOperationService;

    @Autowired
    public ThreadsManager(BootUserService bootUserService, UserOperationService userOperationService, PostOperationService postOperationService) {
        this.bootUserService = bootUserService;
        this.userOperationService = userOperationService;
        this.postOperationService = postOperationService;
    }


    //fixedRate sabıt oranlı
//fixedDelay sabit gecikmeli
//initialdelay baslangıc gecıkmesi
//cron zamanlama ifadesi

    @Scheduled(fixedDelay =30000000, initialDelay = 3000)
    public void startBoots(){

        List<BootUser> bootUsers = bootUserService.getAll();

        for(BootUser bootUser : bootUsers){
            Boot twitterBoot = new TwitterBoot(bootUser, bootUserService, userOperationService, postOperationService);
            try {
                twitterBoot.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
