package com.pawland.member.controller;

import com.pawland.member.domain.Member;
import com.pawland.member.dto.request.MemberRegisterRequest;
import com.pawland.member.dto.request.MemberUpdateRequest;
import com.pawland.member.dto.response.MemberInfoResponse;
import com.pawland.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public MemberInfoResponse getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PostMapping("/register")
    public MemberInfoResponse register(@Valid @RequestBody MemberRegisterRequest request) {
        return memberService.register(request);
    }

    @PutMapping("/{memberId}")
    public MemberInfoResponse update(@PathVariable Long memberId,
                                     @Valid @RequestBody MemberUpdateRequest request) {
        return memberService.update(memberId, request);
    }
}
