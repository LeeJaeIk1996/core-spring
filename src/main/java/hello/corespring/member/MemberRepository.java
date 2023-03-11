package hello.corespring.member;

// 회원 저장소 인터페이스(=역할)
public interface MemberRepository {

    // 회원 가입(=생성, Create)
    void save(Member member);

    // 회원 조회(=Read)
    // 회원의 Id를 통해 회원을 찾는 기능
    Member findById(Long memberId);
}
