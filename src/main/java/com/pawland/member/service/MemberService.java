package com.pawland.member.service;

import com.pawland.member.domain.Member;
import com.pawland.member.dto.request.MemberRegisterRequest;
import com.pawland.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member register(MemberRegisterRequest request) {
        Member member = Member.builder()
            .nickname(request.getNickname())
            .email(request.getEmail())
            .birthday(request.getBirthday())
            .build();
        return memberRepository.save(member);
    }
}
