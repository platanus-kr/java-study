package c.e.qdsl1.member.repository;

import c.e.qdsl1.member.domain.Member;
import jakarta.persistence.EntityManager;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("사용자 추가")
    void save() {
        Member member = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);

        memberRepository.save(member);

        Member testUsername = memberRepository.findByUsername("test_username").orElseThrow();

        assertThat(member.getUsername()).isEqualTo(testUsername.getUsername());
    }

    @Test
    @DisplayName("중복된 사용자 추가 불가")
    void save_duplicate_username() {
        Member member = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);

        memberRepository.save(member);
        entityManager.flush();

        Member dupMember = new Member(null,
                "test_username",
                "test_password",
                "test_nickname__",
                LocalDateTime.now(),
                false);

        memberRepository.save(dupMember);
        assertThatThrownBy(() -> entityManager.flush()).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("중복된 닉네임 추가 불가")
    void save_duplicate_nickname() {
        Member member = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);

        memberRepository.save(member);
        entityManager.flush();

        Member dupMember = new Member(null,
                "test_username_",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);

        memberRepository.save(dupMember);
        assertThatThrownBy(() -> entityManager.flush()).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    @DisplayName("사용자 탈퇴")
    void leave_user() {
        Member member = new Member(null,
                "test_username",
                "test_password",
                "test_nickname",
                LocalDateTime.now(),
                false);

        memberRepository.save(member);
        entityManager.flush();

        System.out.println("여기 영속성 돈다");

        Member findMember = memberRepository.findByUsername("test_username").orElseThrow();
        findMember.leave();

        System.out.println("여기 더티체크 돈다");

        Optional<Member> testUsername = memberRepository.findByUsernameAndLeavedIsFalse("test_username");

        assertThat(testUsername.isEmpty()).isTrue();
    }

}