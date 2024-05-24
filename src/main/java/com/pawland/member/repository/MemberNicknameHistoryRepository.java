package com.pawland.member.repository;

import com.pawland.member.domain.MemberNicknameHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberNicknameHistoryRepository extends JpaRepository<MemberNicknameHistory, Long> {

}
