package com.sample.authenticationservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserModel implements Serializable {

    String userName;
    String password;
    Date lastAudit;

    @Override
    public String toString() {
        return " userName:" + userName + ", lastAudit:" + lastAudit ;
    }
}
