package com.netadex.netadex.dto;

public class LeaderboardDTO {

    private String name;
    private double score;

    public LeaderboardDTO(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }

    public double getScore() { return score; }
}