package com.netadex.netadex.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_duel_stats")
public class UserDuelStats {

    @Id
    @Column(name = "u_id")
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "u_id")
    private User user;

    @Column(name = "duels_today")
    private Integer duelsToday;

    @Column(name = "last_played")
    private LocalDate lastPlayed;

    public UserDuelStats() {}
}