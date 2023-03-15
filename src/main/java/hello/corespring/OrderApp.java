package hello.corespring;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.member.MemberService;
import hello.corespring.member.MemberServiceImpl;
import hello.corespring.order.Order;
import hello.corespring.order.OrderService;
import hello.corespring.order.OrderServiceImpl;

// 주문 도메인 테스트
public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // Order에서 생성했던 toString이 호출된다.
        // order= Order{memberId=1, itemName='itemA', itemPrice=10000, discountPrice=1000}
        System.out.println("order= " + order);

        // calculatePrice() = 제품의 가격 - 할인 가격
        // order.calculatePrice= 9000
        System.out.println("order.calculatePrice= " + order.calculatePrice());
    }

}
