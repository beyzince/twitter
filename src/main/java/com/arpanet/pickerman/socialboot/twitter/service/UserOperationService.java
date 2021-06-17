package com.arpanet.pickerman.socialboot.twitter.service;

import com.arpanet.pickerman.socialboot.twitter.document.UserOperation;
import com.arpanet.pickerman.socialboot.twitter.repository.UserOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOperationService {

    final private UserOperationRepository userOperationRepository;

    @Autowired
    public UserOperationService(UserOperationRepository userOperationRepository) {
        this.userOperationRepository = userOperationRepository;
    }

    public UserOperation save(UserOperation userOperation) {
        return userOperationRepository.save(userOperation);
    }


}
