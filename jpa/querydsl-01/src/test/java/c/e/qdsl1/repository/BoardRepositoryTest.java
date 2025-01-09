package c.e.qdsl1.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BoardRepositoryTest {

//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    @Autowired
//    private CommentRepository commentRepository;

    @Test
    @DisplayName("게시판 생성과 글 작성")
    void create_board_and_new_article() {

    }
}
