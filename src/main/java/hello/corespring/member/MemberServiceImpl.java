package hello.corespring.member;

// 회원 서비스 구현체, 즉 회원 서비스(=MemberService)를 구현한 클래스 (=구현)
// lec) Impl: 구현체가 하나만 있을 때 '인터페이스명+Impl'을 관례상 많이 쓴다.
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
