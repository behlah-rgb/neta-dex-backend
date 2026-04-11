package com.netadex.netadex.repository;

import com.netadex.netadex.model.Politician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliticianRepository extends JpaRepository<Politician, Long> {
}