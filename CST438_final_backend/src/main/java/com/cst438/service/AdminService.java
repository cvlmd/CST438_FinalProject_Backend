package com.cst438.service;

import com.cst438.domain.Attempt;
import com.cst438.domain.AttemptRepository;
import com.cst438.dto.AccountCredentialsDTO;
import com.cst438.dto.AttemptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    @Autowired
    private AttemptRepository attemptRepository;

    public void createUser(AccountCredentialsDTO credentials) {
        // TODO Logic to create and save a new user
    }

    public List<AttemptDTO> getAllAttempts() {
        return attemptRepository.findAll().stream()
                .map(attempt -> convertToAttemptDTO(attempt))
                .collect(Collectors.toList());
    }

    private AttemptDTO convertToAttemptDTO(Attempt attempt) {
        return new AttemptDTO(
                attempt.getId(),
                attempt.getUser().getId(),
                attempt.getFlag(), 
                attempt.getGuessedCountry(),
                attempt.isCorrect()
        );
    }
}
