package com.arpanet.pickerman.socialboot.twitter.document.struct;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class TwitterPlace {
    @Id
    private String id;
    private String countryCode;
    private String country;
    private String fullName;
    private String placeType;
    private String name;
    private String url;
    private String coordinates;



}
