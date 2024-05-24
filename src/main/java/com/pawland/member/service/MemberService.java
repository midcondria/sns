package com.pawland.member.service;

import com.pawland.member.domain.Member;
import com.pawland.member.domain.MemberNicknameHistory;
import com.pawland.member.dto.request.MemberRegisterRequest;
import com.pawland.member.dto.request.MemberUpdateRequest;
import com.pawland.member.dto.response.MemberInfoResponse;
import com.pawland.member.repository.MemberNicknameHistoryRepository;
import com.pawland.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    @Transactional
    public MemberInfoResponse register(MemberRegisterRequest request) {
        Member member = request.toMember();
        memberRepository.save(member);
        saveMemberHistory(member);
        return MemberInfoResponse.of(member);
    }

    public MemberInfoResponse getMember(Long memberId) {
        Member foundMember = findMemberById(memberId);
        return MemberInfoResponse.of(foundMember);
    }

    @Transactional
    public MemberInfoResponse update(Long memberId, MemberUpdateRequest request) {
        Member foundMember = findMemberById(memberId);
        foundMember.changeNickname(request.getNickname());
        saveMemberHistory(foundMember);
        return MemberInfoResponse.of(foundMember);
    }

    private void saveMemberHistory(Member member) {
        MemberNicknameHistory history = MemberNicknameHistory.builder()
            .memberId(member.getId())
            .nickname(member.getNickname())
            .build();
        memberNicknameHistoryRepository.save(history);
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
    }
}
