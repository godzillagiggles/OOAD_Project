package com.ooad.Trading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private double credibilityScore = 0.0;

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();


    @ManyToMany
    @JoinTable(
            name = "member_team", // The join table
            joinColumns = @JoinColumn(name = "member_id"), // Column for Member
            inverseJoinColumns = @JoinColumn(name = "team_id") // Column for Team
    )
    private List<Team> teams;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Vote> votes;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonProperty("firstName")
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @JsonProperty("lastName")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @JsonProperty("email")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @JsonProperty("password")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getCredibilityScore() { return credibilityScore; }
    public void setCredibilityScore(double credibilityScore) { this.credibilityScore = credibilityScore; }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
