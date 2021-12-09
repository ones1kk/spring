package hello.core.order;

import static org.junit.jupiter.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    void createOrder() {

        // given
        Long memberId = 1L;
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOder(memberId, "itemA", 10000);

        // then

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}