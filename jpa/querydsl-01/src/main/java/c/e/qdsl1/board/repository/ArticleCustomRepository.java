package c.e.qdsl1.board.repository;

import c.e.qdsl1.board.application.dto.ArticleRetrieveResponse;

public interface ArticleCustomRepository {

    ArticleRetrieveResponse getDtoById(long id);
}
