package com.netadex.netadex.service;

import com.netadex.netadex.model.*;
import com.netadex.netadex.engine.*;
import com.netadex.netadex.repository.PoliticianCriminalCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final PoliticianCriminalCaseRepository pccRepository;
    private final ScoreCalculator calculator;

    public ScoreService(PoliticianCriminalCaseRepository pccRepository) {
        this.pccRepository = pccRepository;
        this.calculator = new ScoreCalculator();
    }

    public double calculateScore(Politician p) {

        // fetch all links once
        //List<PoliticianCriminalCase> links = pccRepository.findAll();
        List<PoliticianCriminalCase> links =
        pccRepository.findByPolitician_Id(p.getId());
        
        return calculator.calculateScore(p, links);
    }
}