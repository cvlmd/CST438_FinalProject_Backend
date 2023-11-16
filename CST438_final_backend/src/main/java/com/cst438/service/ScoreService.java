package com.cst438.service;

import com.cst438.domain.AttemptRepository;
import com.cst438.domain.UserRepository;
import com.cst438.domain.User;
import com.cst438.dto.ScoreHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    private final AttemptRepository attemptRepository;
    private final UserRepository userRepository;

    @Autowired
    public ScoreService(AttemptRepository attemptRepository, UserRepository userRepository) {
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
    }

    public List<ScoreHistoryDTO> getScoreHistory(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            // Handle the case where the user is not found
        }
        return attemptRepository.findByUser(user).stream()
                .map(attempt -> new ScoreHistoryDTO(/* map fields from attempt to ScoreHistoryDTO */))
                .collect(Collectors.toList());
    }
}
