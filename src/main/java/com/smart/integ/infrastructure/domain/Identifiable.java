package com.finaccess.groboxcooperative.infrastructure.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Base Entity using {@link  GeneratedValue } Identity Strategy to generate a
 * primary key, with a unique UUID, User and Date audit information.
 *
 * @author Isaboke
 */
@MappedSuperclass
@EqualsAndHashCode(of = "id", callSuper = false)
public abstract class Identifiable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
