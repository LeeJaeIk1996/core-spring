package hello.corespring.order;

import hello.corespring.AppConfig;
import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.member.MemberService;
import hello.corespring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    // 주문 생성 테스트
    @Test
    void createOrder() {

        // given
        long memberId = 1L; // 회원 번호
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // when
        memberService.join(member); // 회원 가입
        Order order = orderService.createOrder(memberId, "itemA", 10000);   // 주문 생성

        // then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
