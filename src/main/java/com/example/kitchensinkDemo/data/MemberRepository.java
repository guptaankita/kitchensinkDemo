package com.example.kitchensinkDemo.data;

import com.example.kitchensinkDemo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query
    Optional<Member> findById(Long id);

    @Query
    Optional<Member> findByEmail(String email);
}

