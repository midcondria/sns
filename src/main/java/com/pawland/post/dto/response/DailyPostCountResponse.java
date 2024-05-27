package com.pawland.post.dto.response;

import java.time.LocalDate;

public record DailyPostCountResponse(
    Long memberId,
    LocalDate date,
    Long postCount
) {
}
