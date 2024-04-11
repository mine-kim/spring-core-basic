package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
 * 생성자를 통해서 주입(연결)
 *
 * Impl class는 실행에만 집중. 어떤 구현 객체가 들어오는지 신경안씀.
 *
 * AppConfig를 통해 관심사 분리. 구체 클래스의 선택은 여기에서 담당.
 */
@Configuration
public class AppConfig {

    // Call AppConfig.memberService
    // Call AppConfig.memberRepository
    // Call AppConfig.memberRepository
    // Call AppConfig.orderService
    // Call AppConfig.memberRepository

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
