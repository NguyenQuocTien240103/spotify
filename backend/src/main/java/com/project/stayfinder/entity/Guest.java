package com.project.stayfinder.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.stayfinder.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String email;
    String password;
    String fullName;
    String avatarPath;
    Role role = Role.TENANT;

    @OneToMany(mappedBy = "guest")
    List<BookedRoom> bookedRooms;

    @OneToMany(mappedBy = "guest")
    List<Review> reviews;
}
