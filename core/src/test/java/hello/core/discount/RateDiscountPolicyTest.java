package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1l, "memberVIP", Grade.VIP);
        //when
        int disCount = discountPolicy.discount(member, 10000);
        //then
        assertThat(disCount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 적용되면 안된다.")
    void vip_x() {
        //given
        Member member = new Member(2l, "memberVIP", Grade.BASIC);
        //when
        int disCount = discountPolicy.discount(member, 10000);
        //then
        assertThat(disCount).isEqualTo(0);
    }
}