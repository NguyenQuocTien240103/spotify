package com.project.stayfinder.mapper;

import com.project.stayfinder.entity.Guest;
import com.project.stayfinder.entity.Host;
import com.project.stayfinder.payload.request.CreateAccountRequest;
import com.project.stayfinder.payload.request.UpdateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Guest toGuest(CreateAccountRequest request);

//    @Mapping(target = "email", source = "request.email")
//    @Mapping(target = "password", source = "request.password")
//    @Mapping(target = "fullName", source = "request.fullName")
//    @Mapping(target = "avatarPath", source = "request.avatarPath")
    void toGuest(@MappingTarget Guest guest, UpdateAccountRequest request);
    Host toHost(CreateAccountRequest request);
}
