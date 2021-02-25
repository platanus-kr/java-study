package org.platanus.webappboard.dto;

import lombok.Data;

@Data
public class BoardDto {

    private int boardIndex;
    private String title;
    private String contents;
    private int hitCount;
    private String creatorId;
    private String createdDatetime;
    private String updaterId;
    private String updatedDatetime;
    

}
