package hello.corespring.member;

import java.util.HashMap;
import java.util.Map;

// 메모리 회원 저장소 구현체. 즉, 회원 저장소(MemberRepository)를 구현한 클래스 (=구현)
// lec) 구현체는 인터페이스(=역할)와 다른 패키지에 두는 것이 설계상 좋음
public class MemoryMemberRepository implements MemberRepository {

    // lec) HashMap은 동시성 이슈가 발생할 수 있기 때문에 ConcurrentHashMap을 사용하는 것이 좋다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
