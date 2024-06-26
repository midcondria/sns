package com.pawland.application.controller;

import com.pawland.application.usecase.CreateFollowMemberUsecase;
import com.pawland.application.usecase.GetFollowingMembersUsecase;
import com.pawland.member.dto.response.MemberInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final CreateFollowMemberUsecase createFollowMemberUsecase;
    private final GetFollowingMembersUsecase getFollowingMembersUsecase;

    @PostMapping("/register/{toId}")
    public void create(@PathVariable Long toId, @RequestParam Long fromId) {
        createFollowMemberUsecase.execute(fromId, toId);
    }

    @PostMapping("/following")
    public List<MemberInfoResponse> getFollowingList(@RequestParam Long fromId) {
        return getFollowingMembersUsecase.execute(fromId);
    }
}
