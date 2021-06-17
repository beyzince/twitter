package com.arpanet.pickerman.socialboot.twitter.document.struct;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AnalysingResult {

    /**
     * 0: none
     * 1: spook
     * 2: solab
     * 4: sentiment-hb
     * 8: sentiment-duygu
     * 16: sentiment-siddet
     **/
    private int type;
    private String result;
    private int confidence;
}
