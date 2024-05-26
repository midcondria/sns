package com.pawland.member.service;

import com.pawland.member.domain.Member;
import com.pawland.member.dto.response.MemberInfoResponse;
import com.pawland.member.dto.response.MemberNicknameHistoryResponse;
import com.pawland.member.repository.MemberNicknameHistoryRepository;
import com.pawland.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberReadService {

    private final MemberRepository memberRepository;
    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;


    public MemberInfoResponse getMember(Long memberId) {
        Member foundMember = findMemberById(memberId);
        return MemberInfoResponse.of(foundMember);
    }

    public List<MemberInfoResponse> getMemberList(List<Long> ids) {
        log.info("[ids] = {}", ids);
        return memberRepository.findAllByIdIn(ids).stream()
            .map(MemberInfoResponse::of)
            .toList();
    }

    public List<MemberNicknameHistoryResponse> getNicknameHistories(Long memberId) {
        findMemberById(memberId);
        return memberNicknameHistoryRepository.findAllByMemberId(memberId).stream()
            .map(MemberNicknameHistoryResponse::of)
            .toList();
    }

    private Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));
    }
}
