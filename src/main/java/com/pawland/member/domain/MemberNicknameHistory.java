package com.pawland.member.domain;

import com.pawland.global.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberNicknameHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String nickname;

    @Builder
    public MemberNicknameHistory(Long id, Long memberId, String nickname) {
        this.id = id;
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
