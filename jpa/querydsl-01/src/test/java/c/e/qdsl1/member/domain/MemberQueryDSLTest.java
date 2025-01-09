package c.e.qdsl1.member.domain;

import c.e.qdsl1.member.application.dto.MemberRetrieveResponse;
import c.e.qdsl1.member.application.dto.QMemberRetrieveResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static c.e.qdsl1.member.domain.QMember.member;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberQueryDSLTest {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * JPAQueryFactory를 필드로 제공하면 동시성 문제는 어떻게 될까?
     * 동시성 문제는 JPAQueryFactory를 생성 할 때 제공하는 EntityManager(em)에 달려있다.
     * 스프링 프레임워크는 여러 쓰레드에서 동시에 같은 EntityManager에 접근해도,
     * 트랜잭션 마다 별도의 영속성 컨텍스트를 제공하기 때문에, 동시성 문제는 걱정하 지 않아도 된다.
     */
    private JPAQueryFactory queryFactory;

    @BeforeEach
    public void beforeEach() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @DisplayName("QueryDSL 첫 운전")
    @Test
    void query_dsl_first() {
        Member member = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);
        entityManager.persist(member);

        QMember qUser = QMember.member;

        Member result = queryFactory.selectFrom(qUser).fetchOne();

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(member);
        assertThat(result.getId()).isEqualTo(member.getId());
    }

    @DisplayName("별칭 지정")
    @Test
    void query_dsl_alias() {

        Member emMember = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);
        entityManager.persist(emMember);

        // import c.e.qdsl1.domain.QMember;
        Member findMember = queryFactory.select(member)
                .from(member)
                .where(member.username.eq("test_username"))
                .fetchOne();

        /**
         *
         member.username.eq("member1") // username = 'member1'
         member.username.ne("member1") //username != 'member1'
         member.username.eq("member1").not() // username != 'member1'

         member.username.isNotNull() //이름이 is not null

         member.age.in(10, 20) // age in (10,20)
         member.age.notIn(10, 20) // age not in (10, 20)
         member.age.between(10,30) //between 10, 30

         member.age.goe(30) // age >= 30
         member.age.gt(30) // age > 30
         member.age.loe(30) // age <= 30
         member.age.lt(30) // age < 30

         member.username.like("member%") //like 검색
         member.username.contains("member") // like ‘%member%’ 검색
         member.username.startsWith("member") //like ‘member%’ 검색 ...
         */

        assertThat(findMember.getUsername()).isEqualTo("test_username");

        /**
         * from 절의 서브쿼리 한계
         *
         * JPA JPQL 서브쿼리의 한계점으로 from 절의 서브쿼리(인라인 뷰)는 지원하지 않는다.
         * 당연히 Querydsl도 지원하지 않는다.
         * 하이버네이트 구현체를 사용하면 select 절의 서브쿼리는 지원한다.
         * Querydsl도 하이버네이트 구현체를 사용 하면 select 절의 서브쿼리를 지원한다.
         *
         */
    }

    @DisplayName("DTO Projection")
    @Test
    void dto_projection() {
        Member emMember = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);
        entityManager.persist(emMember);

        // Projection.field       -> 필드 직접 접근
        // Projection.bean        -> setter
        // Projection.constructor -> 생성자
        var memberRetrieveResponse = queryFactory.select(Projections.constructor(MemberRetrieveResponse.class,
                        member.id,
                        member.username,
                        member.nickname))
                .from(member)
                .where(member.username.eq("test_username"))
                .fetchOne();


        // @QueryProjection 활용
        var memberRetrieveResponse2 = queryFactory.select(new QMemberRetrieveResponse(
                        member.id,
                        member.username,
                        member.nickname))
                .from(member)
                .where(member.username.eq("test_username"))
                .fetchOne();

        assertThat(memberRetrieveResponse.getNickname()).isEqualTo(emMember.getNickname());
    }

    @DisplayName("동적 쿼리")
    @Test
    void 동적_쿼리() {

    }

    @DisplayName("벌크 처리")
    @Test
    void bulk_query() {
        /**
         * 항상 이런 것들의 문제는 영속성을 비껴간다는 것.
         */

    }


}
