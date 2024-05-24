package com.pawland.member.dto.response;

import com.pawland.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberInfoResponse {

    private Long id;
    private String nickname;
    private String email;
    private LocalDateTime birthday;

    @Builder
    public MemberInfoResponse(Long id, String nickname, String email, LocalDateTime birthday) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.birthday = birthday;
    }

    public static MemberInfoResponse of(Member member) {
        return MemberInfoResponse.builder()
            .id(member.getId())
            .nickname(member.getNickname())
            .email(member.getEmail())
            .birthday(member.getBirthday())
            .build();
    }
}
