package com.arpanet.pickerman.socialboot.twitter.service;

import com.arpanet.pickerman.socialboot.twitter.document.BootUser;
import com.arpanet.pickerman.socialboot.twitter.repository.BootUserRepository;
import com.arpanet.pickerman.socialboot.twitter.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BootUserService {



    @Autowired
    private BootUserRepository bootUserRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public BootUser getById(Long twitterId) {
        Optional<BootUser> userOpt = bootUserRepository.findById(twitterId);
        return userOpt.isPresent() ? userOpt.get() : null;
    }

    public List<BootUser> getAll() {

        return bootUserRepository.findAll();
    }


    //public BootUser save(BootUser bootUser) {
        //return userRepository.save(bootUser);
   // }

    //public User createUser(User usr) {
      //  return userRepository.insert(usr);
    //}

    public BootUser updateUser(BootUser bootUser) {
        return bootUserRepository.save(bootUser);

    }

    public void delete(Long userId) {
//        Optional<BootUser> userOpt= bootUserRepository.findById(twitterId);
//        if(userOpt.isPresent()){
//
//            //BootUser deleted;
//            bootUserRepository.delete(userOpt.get());
//            //userOpt.get()
//        }else{
//            throw  new ResourceNotFoundException("silinemedi"+ twitterId);
//        }
//
//        //userRepository.deleteById(twitterId);

        Query query = new Query(Criteria.where("id").is(userId));
        Update update = new Update().set("deleted", true);
        mongoTemplate.findAndModify(query, update, BootUser.class);

    }

    public BootUser account(BootUser bootUser){

        return bootUserRepository.save(bootUser);
    }
    public BootUser like(BootUser bootUser){
        return bootUserRepository.save(bootUser);
    }
    public BootUser  reply(BootUser bootUser){
        return bootUserRepository.save(bootUser);
    }
    public BootUser  retweet(BootUser bootUser){
        return bootUserRepository.save(bootUser);
    }
    public BootUser  tweet(BootUser bootUser){
        return bootUserRepository.save(bootUser);
    }
    public  BootUser logout(BootUser bootUser){
        return bootUserRepository.save(bootUser);
    }





}
