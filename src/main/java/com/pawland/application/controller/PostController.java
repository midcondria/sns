package com.pawland.application.controller;

import com.pawland.post.domain.Post;
import com.pawland.post.dto.request.DPRecord;
import com.pawland.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @PostMapping("/daily")
    public String getDailyPostCount(@RequestBody DPRecord request) {
        List<Post> posts = postRepository.groupByCreateDate(1L, request.firstDate(), request.lastDate());
        for (Post post : posts) {
            System.out.println(post);
        }
        return "hi";
    }
}
