package com.cst438.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagRepository extends JpaRepository<QuizFlag, Long> {
    // Additional methods to retrieve flags based on difficulty or other criteria
}
