package com.pawland.member.repository;

import com.pawland.member.domain.MemberNicknameHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberNicknameHistoryRepository extends JpaRepository<MemberNicknameHistory, Long> {

    @Query(value = "SELECT * FROM member_nickname_history h where h.member_id = :memberId", nativeQuery = true)
    List<MemberNicknameHistory> findAllByMemberId(@Param("memberId") Long memberId);
}
