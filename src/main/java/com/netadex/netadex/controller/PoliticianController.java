package com.netadex.netadex.controller;

import com.netadex.netadex.dto.LeaderboardDTO;
import com.netadex.netadex.dto.RateRequest;
import com.netadex.netadex.model.Politician;
import com.netadex.netadex.repository.PoliticianRepository;
import com.netadex.netadex.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PoliticianController {

    private final PoliticianRepository politicianRepository;
    private final ScoreService scoreService;

    public PoliticianController(PoliticianRepository politicianRepository,
                                ScoreService scoreService) {
        this.politicianRepository = politicianRepository;
        this.scoreService = scoreService;
    }

    // =========================
    // GET /leaderboard
    // =========================
    @GetMapping("/leaderboard")
    public List<LeaderboardDTO> getLeaderboard() {

        List<Politician> politicians = politicianRepository.findAll();

        List<LeaderboardDTO> result = new ArrayList<>();

        for (Politician p : politicians) {
            double score = scoreService.calculateScore(p);
            result.add(new LeaderboardDTO(p.getName(), score));
        }

        result.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));

        return result;
    }

    @GetMapping("/politicians")
    public List<Politician> getAllPoliticians() {
        return politicianRepository.findAll();
    }

    @GetMapping("/politician/{id}")
    public Politician getPolitician(@PathVariable Long id) {
        return politicianRepository.findById(id).orElse(null);
    }

    @PostMapping("/rate")
    public String ratePolitician(@RequestBody RateRequest request) {

        Politician p = politicianRepository
                .findById(request.getPoliticianId())
                .orElse(null);

        if (p == null) {
            return "Politician not found";
        }

        // simple update (can improve later)
        p.setRating(
            p.getRating() == null
            ? java.math.BigDecimal.valueOf(request.getRating())
            : p.getRating().add(java.math.BigDecimal.valueOf(request.getRating()))
        );

        politicianRepository.save(p);

        return "Rating submitted";
    }
}