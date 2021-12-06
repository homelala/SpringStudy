package hello.core.order;

import hello.core.anntation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 객체에 대해 생성자 자동 생성
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
//    @Autowired private DiscountPolicy rateDiscountPolicy;
//    0. 필드 주입
//     자바코드로 테스트할 때 수정 불가
//     수정하려면 setter가 필요한데 그럴바에는 수정자로 의존관계 주입
//     테스트를 할때 필요하면 가능
//    @Autowired private  MemberRepository memberRepository;
//    @Autowired private  DiscountPolicy discountPolicy;

//    1. setter로 의존 관계 주입(수정자)
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

//     2. 생성자로 의존관계 주입
//     생성자가 한개만 있으면 @Autowired 생략 가능
     @Autowired //한개이므로 생략 가능함
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + rateDiscountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

//    3. 메소드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
