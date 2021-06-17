package com.arpanet.pickerman.socialboot.twitter.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
public class TwitterUser {
    @Id
    private Long id;
    private Date createDate ;
    private int friendsCount ;
    private boolean hasExtendedProfile;
    private boolean verified;
    private boolean userProtected ;
    private String screenName ;
    private String profileUrl;
    private String name;
    private int listedCount ;
    private int favouritesCount;
    private int statusesCount;
    private int followersCount;
    private String userLocation;
    private  String description;
    private String profileImageUrl;
    private String profileBannerUrl;
    private Date lastParsingDate;
    private Date firstParsingDate;


}
