package ru.dao.AnnotationConfig;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="users")
public class Users implements Serializable {
    private static final long serialVersionUID = -2131365180444923384L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name="age")
    private int Age;

    @Column(name = "name", length = 50)
    private String Name;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    public Users(){}

}
