package com.netadex.netadex.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "politician")
public class Politician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    private BigDecimal assets;
    private BigDecimal liabilities;
    private BigDecimal salary;

    @Column(name = "has_pan")
    private String hasPan; // 'Y' or 'N'

    @Column(name = "education_level")
    private String educationLevel;

    private BigDecimal rating;

    // =========================
    // Relationships
    // =========================

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    @ManyToOne
    @JoinColumn(name = "c_id", nullable = false)
    private Constituency constituency;

    // Required by JPA
    public Politician() {}

    public Politician(String name, Integer age, BigDecimal assets,
                      BigDecimal liabilities, BigDecimal salary,
                      String hasPan, String educationLevel,
                      BigDecimal rating,
                      Party party, Constituency constituency) {

        this.name = name;
        this.age = age;
        this.assets = assets;
        this.liabilities = liabilities;
        this.salary = salary;
        this.hasPan = hasPan;
        this.educationLevel = educationLevel;
        this.rating = rating;
        this.party = party;
        this.constituency = constituency;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public Party getParty() { return party; }

    public Constituency getConstituency() { return constituency; }

    public BigDecimal getAssets() { return assets; }

    public BigDecimal getLiabilities() { return liabilities; }

    public BigDecimal getRating() { return rating; }

    public String getEducationLevel() { return educationLevel; }

    public void setRating(java.math.BigDecimal rating) {
    this.rating = rating;
    }
}