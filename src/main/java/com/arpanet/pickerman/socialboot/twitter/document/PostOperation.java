package com.arpanet.pickerman.socialboot.twitter.document;

import com.arpanet.pickerman.socialboot.twitter.document.struct.PostOperationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class PostOperation {

    private PostOperationType postOperationType;
    private Date createDate;

    @DBRef
    private BootUser bootUser;

    @DBRef
    private TwitterPost post;

}
