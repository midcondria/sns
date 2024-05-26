package com.pawland.follow.service;

import com.pawland.follow.domain.Follow;
import com.pawland.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowReadService {

    private final FollowRepository followRepository;

    public List<Follow> getFollowingList(Long memberId) {
        List<Follow> result = followRepository.findAllByFromMemberId(memberId);
        log.info("[ids] = {}", result);

        return result;
    }
}
