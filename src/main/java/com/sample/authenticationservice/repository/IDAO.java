package com.sample.authenticationservice.repository;

import com.sample.authenticationservice.entity.UserEntity;
import com.sample.authenticationservice.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public interface IDAO extends CrudRepository<UserEntity,Long> {

    default Optional<UserEntity> checkIfExists(UserEntity userEntity){
        Optional<UserEntity> entity = StreamSupport.stream(this.findAll().spliterator(), false)
                .filter(i -> i.getPassword().equals(userEntity.getPassword()) && i.getUserName().equals(userEntity.getUserName()))
                .findFirst();
        return entity;
    }
}
