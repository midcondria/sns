package com.pawland.member.repository;

import com.pawland.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT * FROM member WHERE id in (:ids)", nativeQuery = true)
    List<Member> findAllByIdIn(List<Long> ids);
}
