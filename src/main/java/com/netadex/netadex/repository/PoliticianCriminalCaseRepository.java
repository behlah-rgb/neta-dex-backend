package com.netadex.netadex.repository;

import com.netadex.netadex.model.PoliticianCriminalCase;
import com.netadex.netadex.model.PoliticianCriminalCaseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoliticianCriminalCaseRepository
        extends JpaRepository<PoliticianCriminalCase, PoliticianCriminalCaseId> {
                
                List<PoliticianCriminalCase> findByPolitician_Id(Long id);
}