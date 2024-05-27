package com.pawland.post.repository;

import com.pawland.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post p WHERE p.member_id = :memberId AND p.created_at BETWEEN :firstDate AND :lastDate", nativeQuery = true)
    List<Post> groupByCreateDate(Long memberId, LocalDate firstDate, LocalDate lastDate);
}

