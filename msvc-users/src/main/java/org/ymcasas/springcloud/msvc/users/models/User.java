package org.ymcasas.springcloud.msvc.users.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

}
