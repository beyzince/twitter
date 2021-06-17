package com.arpanet.pickerman.socialboot.twitter.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "isDeleted")
@AllArgsConstructor
@NoArgsConstructor
public class BootUser {

    @Id
    private Long id;

    private String password;
    private long telNo;
    private String email;
    private String username;

    @DBRef
    private TwitterUser twitterUser;

    private  boolean deleted;
}
