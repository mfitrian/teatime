package com.fiteatime.teatime.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.UUID;

@Entity
@Table(name = "teas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tea {

    public enum Type {GREEN, BLACK, OOLONG, HERBAL, WHITE};
    @Column(length = 36)
    @org.hibernate.annotations.Type(type = "uuid-char")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("Id")
    private UUID id;
    private String name;
    private int rating;
    private Type type;

    public Tea () {

    }

    public Tea(String name, Type type, int rating) {
        this.name = name;
        this.type = type;
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
