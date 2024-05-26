package com.pawland.application.controller;

import com.pawland.member.dto.request.MemberRegisterRequest;
import com.pawland.member.dto.request.MemberUpdateRequest;
import com.pawland.member.dto.response.MemberInfoResponse;
import com.pawland.member.dto.response.MemberNicknameHistoryResponse;
import com.pawland.member.service.MemberReadService;
import com.pawland.member.service.MemberWriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberReadService memberReadService;
    private final MemberWriteService memberWriteService;

    @GetMapping("/{memberId}")
    public MemberInfoResponse getMember(@PathVariable Long memberId) {
        return memberReadService.getMember(memberId);
    }

    @PostMapping("/register")
    public MemberInfoResponse register(@Valid @RequestBody MemberRegisterRequest request) {
        return memberWriteService.register(request);
    }

    @PutMapping("/{memberId}")
    public MemberInfoResponse update(@PathVariable Long memberId,
                                     @Valid @RequestBody MemberUpdateRequest request) {
        return memberWriteService.update(memberId, request);
    }

    @GetMapping("/{memberId}/history")
    public List<MemberNicknameHistoryResponse> getNicknameHistories(@PathVariable Long memberId) {
        return memberReadService.getNicknameHistories(memberId);
    }
}
