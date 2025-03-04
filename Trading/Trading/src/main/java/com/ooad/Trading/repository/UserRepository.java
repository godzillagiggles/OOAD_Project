package com.ooad.Trading.repository;

import com.ooad.Trading.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Member, Long> {


}