package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by vagrant on 11/4/16.
 */

@NodeEntity
@JsonIdentityInfo(generator= JSOGGenerator.class)
public class Player {

    @GraphId
    @JsonProperty("id")
    private Long id;
    private String name;
    private String number;

    @Relationship(type = "PLAYS_ON")
    private PlayerPosition position;

    public Player() {
    }

    public Player(String name, String number, PlayerPosition position) {
        this.name = name;
        this.number = number;
        this.position = position;
        this.position.setPlayer(this);
    }

    public Player(String name, String number) {
        this.name = name;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {

        this.position = position;
        this.position.setPlayer(this);
    }
}
