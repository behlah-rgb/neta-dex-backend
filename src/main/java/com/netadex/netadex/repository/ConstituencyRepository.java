package com.netadex.netadex.repository;

import com.netadex.netadex.model.Constituency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstituencyRepository extends JpaRepository<Constituency, Long> {
}