package com.arpanet.pickerman.socialboot.twitter.document;

import com.arpanet.pickerman.socialboot.twitter.document.struct.UserOperationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class UserOperation {

    private UserOperationType userOperationType;
    private Date createDate;

    @DBRef
    private BootUser bootUser;

    @DBRef
    private TwitterUser effectedUser;


}
