package ru.dao.AnnotationConfig;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="role")
public class Role implements Serializable {
        private static final long serialVersionUID = -2131365180444923384L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private long id;

        @Column(name="title")
        private int title;

        @OneToMany(mappedBy = "role")
        private Set<Users> users = new HashSet<Users>();

        public Role(){}

    }
