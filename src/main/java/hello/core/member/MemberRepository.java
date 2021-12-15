package hello.core.member;

import org.springframework.stereotype.Component;

@Component
public interface MemberRepository {

    void save(Member member);

    Member fidById(Long memberId);

}
