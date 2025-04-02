package com.ooad.Trading.controller;

import com.ooad.Trading.repository.MemberTeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:5460")
public class TeamController {

    private final MemberTeamRepository memberTeamRepository;

    public TeamController(MemberTeamRepository memberTeamRepository) {
        this.memberTeamRepository = memberTeamRepository;
    }

    @GetMapping("/my-teams/{email}")
    public ResponseEntity<List<String>> getUserTeams(@PathVariable String email) {
        List<String> teamNames = memberTeamRepository.findTeamNamesByEmail(email);

        if (teamNames.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(teamNames);
    }
}
