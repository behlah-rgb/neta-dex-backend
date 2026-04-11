package com.netadex.netadex.repository;

import com.netadex.netadex.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {
}