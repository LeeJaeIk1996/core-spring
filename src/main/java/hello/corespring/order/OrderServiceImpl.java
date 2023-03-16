package hello.corespring.order;

import hello.corespring.discount.DiscountPolicy;
import hello.corespring.discount.FixDiscountPolicy;
import hello.corespring.member.Member;
import hello.corespring.member.MemberRepository;
import hello.corespring.member.MemoryMemberRepository;

// 주문 서비스 구현체
public class OrderServiceImpl implements OrderService {

    // 회원을 찾기 위해 필요.
    private final MemberRepository memberRepository ;

    // 할인 정책 필요.
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 회원 조회
        Member member = memberRepository.findById(memberId);

        // 할인된 가격 변수
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 주문 엔티티 반환(=주문 생성)
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
