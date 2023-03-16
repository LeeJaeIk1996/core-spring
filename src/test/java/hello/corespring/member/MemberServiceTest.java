package hello.corespring.member;

import hello.corespring.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// 회원 도메인 테스트
// lec) 후에 build할 경우 main의 코드만 나가고 test의 코드는 build될 때 빠진다.
public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {

        // given - 이런게 주어지고
        Member member = new Member(1L, "memberA", Grade.VIP);   // 회원 객체가 주어지고

        // when - 주어진걸로 이렇게 할 때
        memberService.join(member); // 주어진 회원 객체로 회원 가입을 할 때
        Member findMember = memberService.findMember(1L);   // 주어진 회원 객체를 조회할 때

        // then - 이렇게 된다(=검증)
        Assertions.assertThat(member).isEqualTo(findMember);    // 회원 가입한 회원 객체와 조회한 회원 객체가 같을 것이다

        // 결과: Process finished with exit code 0
    }

}
