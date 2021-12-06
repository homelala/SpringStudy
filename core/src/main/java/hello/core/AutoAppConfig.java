package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 빈 클래스에 등록하지 않기 위해 거르는 코드
        basePackages = "hello.core", // 지정하지 않으면 위의 package 하위 파일만 설정
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 간단하게 테스트할 때는 필드 인젝션 사용 가능
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    DiscountPolicy rateDiscountPolicy;

    @Bean
    OrderService AutoOrderService() {
        return new OrderServiceImpl(memberRepository,rateDiscountPolicy);
    }
    
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}