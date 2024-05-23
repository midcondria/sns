package com.pawland.member.dto.request;

import com.pawland.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRegisterRequest {

    @NotBlank(message = "이메일을 확인해주세요.")
    private String email;

    @NotBlank(message = "닉네임을 확인해주세요.")
    private String nickname;

    @NotNull(message = "생년월일을 확인해주세요.")
    private LocalDateTime birthday;

    @Builder
    public MemberRegisterRequest(String email, String nickname, LocalDateTime birthday) {
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public Member toMember() {
        return Member.builder()
            .nickname(nickname)
            .email(email)
            .birthday(birthday)
            .build();
    }
}
