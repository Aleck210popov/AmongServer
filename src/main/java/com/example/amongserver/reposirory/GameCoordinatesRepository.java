package com.example.amongserver.reposirory;

import com.example.amongserver.domain.entity.GameCoordinates;
import com.example.amongserver.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCoordinatesRepository extends JpaRepository<GameCoordinates, Long> {
    List<GameCoordinates> findAllByIsCompleted(boolean isCompleted);
}