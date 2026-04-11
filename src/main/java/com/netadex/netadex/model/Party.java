package com.netadex.netadex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long partyId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "logo_url")
    private String logoUrl;

    // REQUIRED: no-arg constructor (JPA needs this)
    public Party() {}

    public Party(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    // Getters & Setters
    public Long getPartyId() { return partyId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLogoUrl() { return logoUrl; }

    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }
}