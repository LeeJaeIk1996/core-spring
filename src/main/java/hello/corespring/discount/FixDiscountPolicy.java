package hello.corespring.discount;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;

// 정액 할인 정책(=구현)
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   // 1000원 할인

    @Override
    public int discount(Member member, int price) {

        // 만약 회원의 등급(Grade)이 VIP라면 1000원 할인을 해줌
        // 그렇지 않은 경우(BASIC) 할인을 적용하지 않음
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
