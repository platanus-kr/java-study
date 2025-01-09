package c.e.qdsl1.member.application.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MemberRetrieveResponse {
    private long id;
    private String username;
    private String nickname;

    @QueryProjection
    public MemberRetrieveResponse(long id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }
}
