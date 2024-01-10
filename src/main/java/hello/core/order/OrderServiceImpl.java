package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
// 얘 역시 인터페이스만 선언되어있지 그 안에 구현체를 모름! -> DIP 준수

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        /* 할인에 대한건 모르겠으니 discount측에 member 자체를 던짐. -> createOrder가 딱 createOrder 기능만 책임지고 수행
         이 자체가 단일 책임 원칙(SRP)을 잘 지킨거임. */

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
