package com.arpanet.pickerman.socialboot.twitter.document.struct;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TwitterMediaLink {

    @Id
    private Long id;
    private String mediaUrl;

}
