package com.arpanet.pickerman.socialboot.twitter.document;

import com.arpanet.pickerman.socialboot.twitter.document.struct.AnalysingResult;
import com.arpanet.pickerman.socialboot.twitter.document.struct.TwitterMediaLink;
import com.arpanet.pickerman.socialboot.twitter.document.struct.TwitterPlace;
import com.arpanet.pickerman.socialboot.twitter.document.struct.TwitterVideo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwitterPost {

    @Id
    private Long id;

    private List<String> hashtags;
    private String lang;
    private Date createDate;
    private Date parsingDate;
    private String text;

    private TwitterMediaLink twitterMediaLink;
    private TwitterVideo twitterVideo;

    private long inReplyToTweetId;
    private long inReplyToUserId;
    private int retweetCount;
    private int replayCount;

    private int dayId;

    /**
     * 0: none
     * 1: spook
     * 2: solab
     * 4: sentiment-hb
     * 8: sentiment-duygu
     * 16: sentiment-siddet
     **/
    private int analysingState = 0;
    private List<AnalysingResult> analyseResults;

    @DBRef
    private TwitterPost quoteTweet;

    @DBRef
    private List<TwitterUser> mentions;
    @DBRef
    private TwitterUser user;
    @DBRef
    private TwitterPlace place;

    @Transient
    boolean insertState = false;

}
