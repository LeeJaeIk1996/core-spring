package hello.corespring;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.member.MemberService;
import hello.corespring.member.MemberServiceImpl;

// 회원 도메인 테스트
// 이렇게 테스트 하는 것은 좋은 방법이 x -> JUnit 테스트를 사용!
public class MemberApp {

    // tip) psvm을 입력하면 바로 나옴
    public static void main(String[] args) {

        // 회원 가입 및 조회를 위해 memberService 생성
        MemberService memberService = new MemberServiceImpl();

        // 회원 객체 생성 및 회원 가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원 조회
        Member findMember = memberService.findMember(1L);

        // 결과 확인
        System.out.println("new member= " + member.getName());
        System.out.println("find member= " + findMember.getName());



    }

}
