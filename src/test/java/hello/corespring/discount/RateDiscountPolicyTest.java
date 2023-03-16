package hello.corespring.discount;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

// 정률 정책 할인 테스트
// tip) RateDiscountPolicy 클래스에서 ctrl + shift + T를 누르면 Test 클래스를 쉽게 생성할 수 있다!!
public class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")  // lec) 한글로 Test 메서드 이름을 쓸 수 있다. JUnit 5부터 지원
    void vip_o() {

        // given - VIP 회원이 존재할 때
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // when - 할인 정책을 적용할 때
        int discount = discountPolicy.discount(member, 10000);

        // then - 할인이 제대로 적용되는지
        assertThat(discount).isEqualTo(1000);
    }

    // lec) Test를 할 때는 성공 테스트 뿐만 아니라 실패 테스트도 만들어봐야 한다!
    @Test
    @DisplayName("VIP가 아닌 경우 할인이 적용되어선 안된다.")
    void vip_x() {

        // given - 일반 회원이 존재할 때(VIP가 아닌 BASIC 회원)
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        // when - 할인 정책을 적용할 때
        int discount = discountPolicy.discount(member, 10000);

        // then - 할인이 적용하지 않는지
        // tip) Alt + enter로 on-demand static import 해주는 것이 좋다.
        assertThat(discount).isEqualTo(0);
    }

}
