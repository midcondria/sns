package com.pawland.member.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateRequest {

    @NotBlank(message = "변경할 닉네임을 확인해주세요.")
    private String nickname;

    @Builder
    public MemberUpdateRequest(String nickname) {
        this.nickname = nickname;
    }
}
