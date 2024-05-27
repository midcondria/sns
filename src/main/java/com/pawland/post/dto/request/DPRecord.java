package com.pawland.post.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DPRecord(
    Long memberId,

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate firstDate,

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)

    LocalDate lastDate) {
}
