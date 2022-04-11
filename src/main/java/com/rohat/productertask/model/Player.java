package com.rohat.productertask.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private EPosition position;

    public Player(String firstName, String lastName, EPosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }


}
