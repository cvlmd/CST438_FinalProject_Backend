package com.cst438.controller;

import com.cst438.service.ScoreService;
import com.cst438.dto.ScoreHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/history")
    public ResponseEntity<List<ScoreHistoryDTO>> getScoreHistory(@RequestParam String username) {
        List<ScoreHistoryDTO> history = scoreService.getScoreHistory(username);
        return ResponseEntity.ok(history);
    }
}
