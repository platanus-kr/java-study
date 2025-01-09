package c.e.qdsl1.member.repository;

import c.e.qdsl1.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    Optional<Member> findByUsernameAndLeavedIsFalse(String username);

    List<Member> findAllByLeavedIsFalse();

}
