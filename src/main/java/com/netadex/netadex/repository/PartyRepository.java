package com.netadex.netadex.repository;

import com.netadex.netadex.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}