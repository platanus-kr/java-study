package c.e.qdsl1.board.repository;

import c.e.qdsl1.member.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class ArticleRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ArticleRepository articleRepository;

    private long MEMBER_ID = 0L;

    @BeforeEach
    void beforeEach() {
        Member member = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);
        entityManager.persist(member);
        MEMBER_ID = member.getId();
    }

    @Test
    @DisplayName("글쓰기")
    void article_write() {
    }
}
