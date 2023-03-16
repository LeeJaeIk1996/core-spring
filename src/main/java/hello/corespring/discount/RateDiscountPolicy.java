package hello.corespring.discount;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;

// 정률 할인 정책(=구현)
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;   // 10% 할인

    @Override
    public int discount(Member member, int price) {

        // 만약 VIP라면 10% 할인을 적용
        // VIP가 아니라면 할인 정책을 적용하지 않음(=retrun 0)
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }

    }
}
