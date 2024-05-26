package com.pawland.application.usecase;

import com.pawland.follow.service.FollowWriteService;
import com.pawland.member.dto.response.MemberInfoResponse;
import com.pawland.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFollowMemberUsecase {

    private final MemberReadService memberReadService;
    private final FollowWriteService followWriteService;

    public void execute(Long fromMemberId, Long toMemberId) {
        MemberInfoResponse fromMember = memberReadService.getMember(fromMemberId);
        MemberInfoResponse toMember = memberReadService.getMember(toMemberId);

        followWriteService.create(fromMember, toMember);
    }
}
