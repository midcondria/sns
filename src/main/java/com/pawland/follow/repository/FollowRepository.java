package com.pawland.follow.repository;

import com.pawland.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query(value = "SELECT * FROM follow f WHERE f.from_member_id = :fromMemberId", nativeQuery = true)
    List<Follow> findAllByFromMemberId(@Param("fromMemberId") Long fromMemberId);
}
