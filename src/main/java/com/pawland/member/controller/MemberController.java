package com.pawland.member.controller;

import com.pawland.member.domain.Member;
import com.pawland.member.dto.request.MemberRegisterRequest;
import com.pawland.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Member register(@Valid @RequestBody MemberRegisterRequest request) {
        return memberService.register(request);
    }
}
