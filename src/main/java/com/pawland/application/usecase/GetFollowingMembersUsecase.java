package com.pawland.application.usecase;

import com.pawland.follow.domain.Follow;
import com.pawland.follow.service.FollowReadService;
import com.pawland.member.dto.response.MemberInfoResponse;
import com.pawland.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFollowingMembersUsecase {

    private final MemberReadService memberReadService;
    private final FollowReadService followReadService;

    public List<MemberInfoResponse> execute(Long memberId) {
        List<Long> followingIds = followReadService.getFollowingList(memberId).stream()
            .map(Follow::getToMemberId)
            .toList();
        return memberReadService.getMemberList(followingIds);
    }
}
