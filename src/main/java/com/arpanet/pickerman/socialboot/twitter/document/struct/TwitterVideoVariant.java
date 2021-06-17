package com.arpanet.pickerman.socialboot.twitter.document.struct;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TwitterVideoVariant {

    @Id
    private String id;
    private String contentType;
    private String urlVariant;
    private Long bitrate;
}
