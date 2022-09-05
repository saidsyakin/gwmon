package com.said.gwmon.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
public abstract class Measurement {
    @Id
    @GeneratedValue
    protected UUID id;

    @Column(name = "user_id", nullable = false) @NotNull
    protected UUID userId;

    @Column(name = "created_date")
    protected Instant createdDate = Instant.now();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
