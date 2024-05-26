package com.pawland.member.dto.response;

import com.pawland.member.domain.MemberNicknameHistory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberNicknameHistoryResponse {

    private Long id;
    private Long memberId;
    private String nickname;
    private LocalDateTime createdAt;

    @Builder
    public MemberNicknameHistoryResponse(Long id, Long memberId, String nickname, LocalDateTime createdAt) {
        this.id = id;
        this.memberId = memberId;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }

    public static MemberNicknameHistoryResponse of(MemberNicknameHistory history) {
        return MemberNicknameHistoryResponse.builder()
            .id(history.getId())
            .memberId(history.getMemberId())
            .nickname(history.getNickname())
            .createdAt(history.getCreatedAt())
            .build();
    }
}
