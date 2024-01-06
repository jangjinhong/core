package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    } // 원래는 이걸 서비스에 직접 써줌 A a = new a-1(); 의 형태로
    // 즉, new로 가져올 리포지토리를 서비스가 직접 정함(배우가 캐스팅;;한꼴) 이걸 여기다가 해주겠다

    public OrderService orderService() { //얘는 매개변수가 2개가 필요함 정책과 저장소
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
