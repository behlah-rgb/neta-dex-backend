package com.netadex.netadex.model;

import java.io.Serializable;
import java.util.Objects;

public class PoliticianCriminalCaseId implements Serializable {

    private Long politician;
    private Long criminalCase;

    public PoliticianCriminalCaseId() {}

    public PoliticianCriminalCaseId(Long politician, Long criminalCase) {
        this.politician = politician;
        this.criminalCase = criminalCase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PoliticianCriminalCaseId)) return false;
        PoliticianCriminalCaseId that = (PoliticianCriminalCaseId) o;
        return Objects.equals(politician, that.politician) &&
               Objects.equals(criminalCase, that.criminalCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(politician, criminalCase);
    }
}