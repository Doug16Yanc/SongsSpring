package com.example.ProjectSpring.resources;

import com.example.ProjectSpring.entities.Songs;
import com.example.ProjectSpring.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/songs")
public class SongsResource {

    @Autowired
    private SongsRepository songsRepository;
    @GetMapping
    public ResponseEntity<List<Songs>> findAll() {
        List<Songs> list = songsRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Songs> findById(@PathVariable Long id) {
        Songs obj = songsRepository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }
}