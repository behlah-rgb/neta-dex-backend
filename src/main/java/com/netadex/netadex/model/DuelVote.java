package com.netadex.netadex.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duel_vote")
public class DuelVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "winner_p_id")
    private Politician winner;

    @ManyToOne
    @JoinColumn(name = "loser_p_id")
    private Politician loser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public DuelVote() {}

    public DuelVote(User user, Politician winner, Politician loser) {
        this.user = user;
        this.winner = winner;
        this.loser = loser;
        this.createdAt = LocalDateTime.now();
    }
}