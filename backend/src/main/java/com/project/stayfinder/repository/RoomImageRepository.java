package com.project.stayfinder.repository;

import com.project.stayfinder.entity.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomImageRepository extends JpaRepository<RoomImage, String> {
}