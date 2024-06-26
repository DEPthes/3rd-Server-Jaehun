package depth.board.Member.Repository;

import depth.board.Member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    // 이메일로 회원 조회
    Optional<Member> findByEmail(String email);
}
