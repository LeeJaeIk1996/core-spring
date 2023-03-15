package hello.corespring.discount;

import hello.corespring.member.Member;

// 할인 정책 인터페이스(=역할)
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액. 즉, discount를 호출할 경우 할인 금액을 return 해준다.
     */
    int discount(Member member, int price);

}
