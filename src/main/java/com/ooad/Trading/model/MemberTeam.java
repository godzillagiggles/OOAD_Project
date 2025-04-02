package com.ooad.Trading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "member_team")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Add an ID for uniqueness
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "team_name", nullable = false)
    private String teamName;
}
