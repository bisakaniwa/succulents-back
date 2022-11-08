package com.succulents.controller;

import com.succulents.model.Succulent;
import com.succulents.service.SucculentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/succulents")
@CrossOrigin
public class SucculentController {

    @Autowired
    private SucculentService service;

    @GetMapping
    ResponseEntity<List<Succulent>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Succulent> findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @PostMapping
    ResponseEntity<Succulent> save(@RequestBody Succulent succulent) {
        return new ResponseEntity<>(this.service.save(succulent), HttpStatus.CREATED);
    }
}
