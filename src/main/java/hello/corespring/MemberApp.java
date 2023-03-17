package hello.corespring;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.member.MemberService;
import hello.corespring.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 회원 도메인 테스트
// 이렇게 테스트 하는 것은 좋은 방법이 x -> JUnit 테스트를 사용!
public class MemberApp {

    // tip) psvm을 입력하면 바로 나옴
    public static void main(String[] args) {

        //  // 어플리케이션 전체를 설정하고 구성하는 AppConfig 클래스 생성
        //  AppConfig appConfig = new AppConfig();

        // ApplicationContext: 스프링 애플리케이션 전반에 걸쳐 모든 구성요소의 제어 작업을 담당하는 IoC 엔진
        // ApplicationContext는 BeanFactory에 부가기능을 추가한 것
        // lec) ApplicationContext: 스프링 컨테이너라 보면 된다. @Bean 객체들을 관리해주는 것이다.
        // AnnotationConfigApplicationContext는 ApplicationContext 인터페이스의 구현체이다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //  // 회원 가입 및 조회를 위해 memberService 생성
        //  MemberService memberService = appConfig.memberService();

        // lec) 스프링 컨테이너에 bean이 등록되면 기본적으로 메서드 이름(=memberService)으로 등록된다.
        // 즉, public MemberService memberService() {...} 이므로 name은 memberService인 것이다.
        // getBean(빈 이름, 타입)으로 구성되어 있다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

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
