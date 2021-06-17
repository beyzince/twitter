package com.arpanet.pickerman.socialboot.twitter.document.struct;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
public class TwitterVideo {
    @Id
    private Long id;
    private String type;
    private String mediaUrl;
    private Long durationMillis;
    private List<TwitterVideoVariant> twitterVideoVariant;
}

