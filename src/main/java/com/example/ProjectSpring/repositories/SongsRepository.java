package com.example.ProjectSpring.repositories;


import com.example.ProjectSpring.entities.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {

}