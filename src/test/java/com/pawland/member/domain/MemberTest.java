package com.pawland.member.domain;

import com.pawland.utils.MemberFixtureFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
    void changeNickname1() {
        // given
        Member member = MemberFixtureFactory.create();
        String toChangeNickname = "나는짱";

        // when
        member.changeNickname(toChangeNickname);

        // then
        assertThat(member.getNickname()).isEqualTo("나는짱");
    }

    @DisplayName("닉네임은 10자를 초과할 수 없다.")
    @Test
    void changeNickname2() {
        // given
        Member member = MemberFixtureFactory.create();
        String toChangeNickname = "나는짱12345678910";

        // expected
        assertThatThrownBy(() -> member.changeNickname(toChangeNickname))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("닉네임 최대 길이 초과");
    }
}