package com.netadex.netadex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "constituency")
public class Constituency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Constituency() {}

    public Constituency(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}