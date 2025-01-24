package com.project.stayfinder.repository;

import com.project.stayfinder.entity.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, String> {
}