package c.e.qdsl1.board.application.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.time.LocalDateTime;

public class ArticleRetrieveResponse {
    private long id;
    private String title;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    // author
    private long memberId;
    private String memberUsername;
    private String memberNickname;
    private boolean leaved;

    @QueryProjection
    public ArticleRetrieveResponse(long id,
                                  String title,
                                  String content,
                                  LocalDateTime created,
                                  LocalDateTime updated,
                                  long memberId,
                                  String memberUsername,
                                  String memberNickname,
                                  boolean leaved) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.memberId = memberId;
        this.memberUsername = memberUsername;
        this.memberNickname = memberNickname;
        this.leaved = leaved;
    }
}
