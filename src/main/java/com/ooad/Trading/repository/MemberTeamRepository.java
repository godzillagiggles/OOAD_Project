package com.ooad.Trading.repository;

import com.ooad.Trading.model.MemberTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberTeamRepository extends JpaRepository<MemberTeam, Long> { // ✅ ID is Long now

    @Query("SELECT mt.teamName FROM MemberTeam mt WHERE mt.email = :email")
    List<String> findTeamNamesByEmail(@Param("email") String email);  // ✅ Fetch teams correctly
}
