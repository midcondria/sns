package com.pawland.post.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class DailyPostCountRequest {

    private Long memberId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime firstDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime lastDate;

    @Builder
    public DailyPostCountRequest(Long memberId, LocalDateTime firstDate, LocalDateTime lastDate) {
        this.memberId = memberId;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }
}
