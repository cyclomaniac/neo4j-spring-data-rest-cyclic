package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * Created by vagrant on 11/4/16.
 */

@NodeEntity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Team {

    @GraphId
    @JsonProperty("id")
    private Long id;
    private String name;

    @Relationship(type = "PLAYS_ON", direction = Relationship.INCOMING)
    Set<PlayerPosition> teamPlayers;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

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

    public Set<PlayerPosition> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(Set<PlayerPosition> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }
}
