package hello.core;


import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//공연 기획자 :  역할을 설정
// 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
//**객체의 생성과 연결은 AppConfig가 담당한다
/*
* 객체의 생성과 연결은 AppConfig가 담당한다
* Appconfig 객체는 memoryMemberRepository 객체를 생성하고
* 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다
* 클라이언트인 memberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것
* 같다고 해서 DI(의존성주입)이라 한다.
* OrderServiceImpl의 생성자를 통해서 어떤 구현 객체를 주입할지 오직 외부(AppConfig)에서 결정한다.*/