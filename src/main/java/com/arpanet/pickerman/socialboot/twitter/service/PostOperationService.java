package com.arpanet.pickerman.socialboot.twitter.service;

import com.arpanet.pickerman.socialboot.twitter.document.PostOperation;
import com.arpanet.pickerman.socialboot.twitter.repository.PostOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOperationService {

    final private PostOperationRepository postOperationRepository;

    @Autowired
    public PostOperationService(PostOperationRepository postOperationRepository) {
        this.postOperationRepository = postOperationRepository;
    }

    public PostOperation save(PostOperation postOperation) {
        return postOperationRepository.save(postOperation);
    }


}
