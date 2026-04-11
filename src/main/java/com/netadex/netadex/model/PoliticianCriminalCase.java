package com.netadex.netadex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "politician_criminal_case")
@IdClass(PoliticianCriminalCaseId.class)
public class PoliticianCriminalCase {

    @Id
    @ManyToOne
    @JoinColumn(name = "p_id")
    private Politician politician;

    @Id
    @ManyToOne
    @JoinColumn(name = "case_id")
    private CriminalCase criminalCase;

    // Required by JPA
    public PoliticianCriminalCase() {}

    public PoliticianCriminalCase(Politician politician, CriminalCase criminalCase) {
        this.politician = politician;
        this.criminalCase = criminalCase;
    }

    public Politician getPolitician() { return politician; }

    public CriminalCase getCriminalCase() { return criminalCase; }
}