package com.pawland.post.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private String content;

    private LocalDateTime createdDate;

    @Builder
    public Post(Long id, Long memberId, String content, LocalDateTime createdDate) {
        this.id = id;
        this.memberId = memberId;
        this.content = content;
        this.createdDate = createdDate;
    }
}
