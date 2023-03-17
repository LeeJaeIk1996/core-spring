package hello.corespring;

import hello.corespring.discount.DiscountPolicy;
import hello.corespring.discount.FixDiscountPolicy;
import hello.corespring.discount.RateDiscountPolicy;
import hello.corespring.member.MemberRepository;
import hello.corespring.member.MemberService;
import hello.corespring.member.MemberServiceImpl;
import hello.corespring.member.MemoryMemberRepository;
import hello.corespring.order.OrderService;
import hello.corespring.order.OrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 전체를 설정하고 구성하는 클래스
// 구현 객체를 생성하고 연결하는 책임을 갖논 설정 클래스
@Configuration
public class AppConfig {

    // 前: private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 즉, 이전에는 객체를 생성한 뒤 인터페이스에 대한 구현체를 MemberServieImpl에서 직접 할당했었음
    // 後: MemberRepository의 구현체로 들어갈 것을 MemberServiceImpl의 생성자를 통해서 선택함!
    // 즉, 어디선가 AppConfig를 통해 MemberService를 불러다 쓸 경우 MemberServiceImpl(구현체) 객체가 생성되는데
    // 이 때 MemoryMemberRepository가 들어가게 됨.
    // 이렇게 생성자를 통해서 객체가 들어간다고 해서 '생성자 주입'이라고 한다.
    @Bean
    public MemberService memberService() {                  // 역할 생성
        return new MemberServiceImpl(memberRepository());   // 구현체 반환
    }

    // 구현체들을 생성자를 통해 주입해준다!
    @Bean
    public OrderService orderService() {                    // 역할 생성
        return new OrderServiceImpl(                        // 구현체 반환
                memberRepository(),
                discountPolicy());
    }

    // tip) Ctrl + Alt + M: 드래그한 부분을 외부 메소드로 만들어주는 Extract Method.
    @Bean
    public MemberRepository memberRepository() {            // 역할 생성
        return new MemoryMemberRepository();                // 구현체 반환
    }

    @Bean
    public DiscountPolicy discountPolicy() {                // 역할 생성
        // return new FixDiscountPolicy();                  // 구현체 반환
        return new RateDiscountPolicy();
    }

}
