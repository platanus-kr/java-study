package c.e.qdsl1.board.repository;

import c.e.qdsl1.board.application.dto.ArticleRetrieveResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import static c.e.qdsl1.board.domain.QArticle.article;
import static c.e.qdsl1.member.domain.QMember.member;

public class ArticleCustomRepositoryImpl implements ArticleCustomRepository {

    private final JPAQueryFactory queryFactory;

    public ArticleCustomRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public ArticleRetrieveResponse getDtoById(long id) {
        return queryFactory
                .select(Projections.constructor(ArticleRetrieveResponse.class,
                        article.id,
                        article.title,
                        article.content,
                        article.created,
                        article.updated,
                        member.id,
                        member.username,
                        member.nickname,
                        member.leaved))
                .from(article)
                .leftJoin(member).on(article.authorId.eq(member.id))
                .fetchOne();

        // 이렇게 하면 DTO가 QueryDSL 을 의존하게 됨.
        //        return queryFactory
        //                .select(new QArticleRetrieveResponse(
        //                        article.id,
        //                        article.title,
        //                        article.content,
        //                        article.created,
        //                        article.updated,
        //                        member.id,
        //                        member.username,
        //                        member.nickname,
        //                        member.leaved))
        //                .from(article)
        //                .leftJoin(member).on(article.authorId.eq(member.id))
        //                .fetchOne();
    }
}
