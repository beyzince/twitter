package com.arpanet.pickerman.socialboot.twitter.repository;

import com.arpanet.pickerman.socialboot.twitter.document.BootUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BootUserRepository extends MongoRepository<BootUser, Long> {


    @Query(value = "{username:?0}", count = true)
    long findCustomByUser(String username);
    //long findByDeleted(boolean deleted);


    Optional<BootUser> findByIdAndDeletedFalse(Long twitterId);


}