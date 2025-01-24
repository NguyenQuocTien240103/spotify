package com.project.stayfinder.entity;

import com.project.stayfinder.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    Guest guest;

    @OneToOne
    @JoinColumn(name = "room_id")
    Room room;

    Date checkInDate;
    Date checkOutDate;
    Date bookingDate;
    Status status = Status.PENDING;
    double totalPrice; // in USD

}
