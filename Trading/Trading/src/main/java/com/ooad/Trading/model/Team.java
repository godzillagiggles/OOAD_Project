package com.ooad.Trading.model;

import jakarta.persistence.*;
import java.util.List;

@Entity  // Marks this class as a JPA entity (table in DB)
@Table(name = "teams") // Names the table as "teams"
public class Team {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false, unique = true) // Team name must be unique and not null
    private String name;

    @ManyToMany(mappedBy = "teams")
    private List<Member> members; // A team has multiple members

    // Default constructor (required by JPA)
    public Team() {}

    // Constructor
    public Team(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
