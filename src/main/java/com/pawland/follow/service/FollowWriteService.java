package com.pawland.follow.service;

import com.pawland.follow.domain.Follow;
import com.pawland.follow.repository.FollowRepository;
import com.pawland.member.dto.response.MemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class FollowWriteService {

    private final FollowRepository followRepository;

    public void create(MemberInfoResponse fromMember, MemberInfoResponse toMember) {
        Assert.isTrue(!fromMember.getId().equals(toMember.getId()), "From, To 회원은 동일할 수 없습니다.");

        Follow follow = Follow.builder()
            .fromMemberId(fromMember.getId())
            .toMemberId(toMember.getId())
            .build();

        followRepository.save(follow);
    }
}
