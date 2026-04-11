package com.netadex.netadex.engine;

import com.netadex.netadex.model.*;

import java.math.BigDecimal;
import java.util.List;

public class ScoreCalculator {

    private static final double W1 = 0.4;
    private static final double W2 = 0.2;
    private static final double W3 = 0.3;
    private static final double W4 = 0.1;

    public double calculateScore(Politician p, List<PoliticianCriminalCase> links) {

        double E = getEducationScore(p.getEducationLevel());

        double netWorth = calculateNetWorth(p);
        double Sw = Math.log10(netWorth <= 0 ? 1 : netWorth);

        double Pc = calculateCriminalPenalty(p, links);

        double V = p.getRating() != null ? p.getRating().doubleValue() : 0;

        return (W1 * E) + (W2 * Sw) - (W3 * Pc) + (W4 * V);
    }

    // =========================

    private double calculateNetWorth(Politician p) {

        BigDecimal assets = p.getAssets() != null ? p.getAssets() : BigDecimal.ZERO;
        BigDecimal liabilities = p.getLiabilities() != null ? p.getLiabilities() : BigDecimal.ZERO;

        return assets.subtract(liabilities).doubleValue();
    }

    private double calculateCriminalPenalty(Politician p,
                                            List<PoliticianCriminalCase> links) {

        double sum = 0;

        for (PoliticianCriminalCase pc : links) {
            if (pc.getPolitician().getId().equals(p.getId())) {

                IPCMaster ipc = pc.getCriminalCase().getIpcMaster();
                sum += ipc.getSeverityWeight();
            }
        }

        return sum;
    }

    private double getEducationScore(String level) {

        if (level == null) return 0;

        return switch (level.toLowerCase()) {
            case "phd" -> 10;
            case "masters" -> 8;
            case "bachelors" -> 6;
            case "12th" -> 4;
            default -> 2;
        };
    }
}