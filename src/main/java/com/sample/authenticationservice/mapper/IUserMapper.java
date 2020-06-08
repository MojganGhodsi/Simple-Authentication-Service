package com.sample.authenticationservice.mapper;

import com.sample.authenticationservice.entity.UserEntity;
import com.sample.authenticationservice.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    IUserMapper instance = Mappers.getMapper(IUserMapper.class);

    UserEntity userModelToUserEntity(UserModel model);

    UserModel userEntityToUserModel(UserEntity entity);
}
