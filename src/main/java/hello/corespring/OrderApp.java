package hello.corespring;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.member.MemberService;
import hello.corespring.member.MemberServiceImpl;
import hello.corespring.order.Order;
import hello.corespring.order.OrderService;
import hello.corespring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 주문 도메인 테스트
public class OrderApp {

    public static void main(String[] args) {

        //  // 어플리케이션 전체를 설정하고 구성하는 AppConfig 클래스 생성
        //  AppConfig appConfig = new AppConfig();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //  MemberService memberService = appConfig.memberService();
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        //  OrderService orderService = appConfig.orderService();
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

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
