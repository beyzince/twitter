package com.arpanet.pickerman.socialboot.twitter.repository;

import com.arpanet.pickerman.socialboot.twitter.document.PostOperation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostOperationRepository extends MongoRepository<PostOperation, Long> {

}