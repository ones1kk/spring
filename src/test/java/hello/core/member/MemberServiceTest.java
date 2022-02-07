package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemberServiceTest {

//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

    MemberService memberService = new MemberServiceImpl();

    @Test
    void Join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        // then
        assertThat(member).isEqualTo(findMember);
    }


}