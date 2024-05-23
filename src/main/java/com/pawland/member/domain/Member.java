package com.pawland.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Getter
@Entity
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nickname;

    @NotNull
    private String email;

    @NotNull
    private LocalDateTime birthday;

    private static final Long NAME_MAX_LENGTH = 10L;

    @Builder
    public Member(Long id, String nickname, String email, LocalDateTime birthday) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.birthday = Objects.requireNonNull(birthday);

        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);
    }

    public void changeNickname(String toChangeNickname) {
        Objects.requireNonNull(toChangeNickname);
        validateNickname(toChangeNickname);
        this.nickname = toChangeNickname;
    }

    private void validateNickname(String nickname) {
        Assert.isTrue(nickname != null, "닉네임은 누락할 수 없습니다.");
        Assert.isTrue(!nickname.isBlank(), "닉네임은 빈 값일 수 없습니다.");
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "닉네임 최대 길이 초과");
    }
}
