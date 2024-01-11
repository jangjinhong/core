package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /*
    * 여기서 포인트는, MemberServiceImpl에 MemoryMemberRepository에 대한 코드가 없다는 것이다.
    * 오직 인터페이스만 존재한다 (추상화에만 의존-> "DIP 준수")
    * 구체적인 내용을 모름 appconfig에서 생성해서 넣어줌
    * 이것은,
    * 생성자를 통해 객체가 인스턴스 생성된게 들어간다는 의미로 "생성자 주입"이라고 한다
    * */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
