package c.e.qdsl1.board.repository;

import c.e.qdsl1.board.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {
}
