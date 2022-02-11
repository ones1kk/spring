package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "userA", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository,
            new FixDiscountPolicy());
        Order order = orderService.createOder(1L, "itemA", 10000);

        Member findMember = memoryMemberRepository.findById(1L);

        Assertions.assertThat(order.getMemberId()).isSameAs(findMember.getId());
    }
}
