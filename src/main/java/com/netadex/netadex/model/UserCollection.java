package com.netadex.netadex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_collection")
@IdClass(UserCollectionId.class)
public class UserCollection {

    @Id
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "p_id")
    private Politician politician;

    private Boolean unlocked;

    public UserCollection() {}
}