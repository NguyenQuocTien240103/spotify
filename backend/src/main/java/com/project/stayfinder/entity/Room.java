package com.project.stayfinder.entity;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String description;
    String location;
    String detailAddress;
    double price; // per night, in USD
    String type;
    boolean isAvailable = true;
    double rating; // 1-5

    @OneToMany(mappedBy = "room")
    List<RoomImage> images;

    @ManyToOne
    @JoinColumn(name = "host_id")
    Host host;

    @OneToOne(mappedBy = "room")
    BookedRoom bookedRoom;

    @OneToMany(mappedBy = "room")
    List<Review> reviews;
}
