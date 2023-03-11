package hello.corespring.member;

// 회원 서비스 구현체, 즉 회원 서비스(=MemberService)를 구현한 클래스 (=구현)
// lec) Impl: 구현체가 하나만 있을 때 '인터페이스명+Impl'을 관례상 많이 쓴다.
public class MemberServiceImpl implements MemberService{

    // MemoryMemberRepository(=구현체)까지 의존한다는 문제가 있음.
    // 즉, MemberRepository(=역할,추상) 뿐만 아니라 MemoryMemberRepository(=구현)까지 의존하는 문제가 있다.
    // 이는 후에 변경 사항이 생길 경우 문제가 된다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        // save를 호출하면 다형성에 의해 MemoryMemberRepository에 있는 save가 호출된다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
