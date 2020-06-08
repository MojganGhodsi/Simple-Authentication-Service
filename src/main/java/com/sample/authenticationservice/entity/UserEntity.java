package com.sample.authenticationservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "user_entity")
@SequenceGenerator(name = "user_entity_sequence", initialValue = 1)
@Table(uniqueConstraints= @UniqueConstraint(columnNames = {"USER_NAME", "PASSWORD"}))
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "USER_NAME")
    String userName;

    @Column(name = "PASSWORD")
    String password;

    @Column(name = "LAST_AUDIT")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastAudit;

    public String toString() {
        return id + " | " + userName + " | " + lastAudit;
    }
}
