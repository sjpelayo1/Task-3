package com.example.Task3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import com.example.Task3.Models.Helicopter;
import com.example.Task3.Services.HelicopterService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/helicopters")
public class HelicopterController {

    @Autowired
    private HelicopterService helicopterService;

    @GetMapping
    public ResponseEntity<Object> getAllHelicopters() {
        List<Helicopter> helicopters = helicopterService.getAllHelicopters();
        return ResponseEntity.status(HttpStatus.OK).body(helicopters);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHelicopter(@PathVariable Integer ID) {
        Helicopter helicopter = helicopterService.getHelicopterById(ID);

        if (helicopter != null) {
            return ResponseEntity.status(HttpStatus.OK).body(helicopter);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addHelicopter(@Valid @RequestBody Helicopter helicopter) {
        try {
            helicopterService.addHelicopter(helicopter);
            return ResponseEntity.status(HttpStatus.CREATED).body(helicopter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateHelicopter(@PathVariable Integer ID,
            @Valid @RequestBody Helicopter updatedHelicopter) {
        boolean foundUpdated = helicopterService.updateHelicopter(ID, updatedHelicopter);
        if (foundUpdated) {
            Helicopter updatedIdHelicopter = helicopterService.getHelicopterById(ID);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdHelicopter);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHelicopter(@PathVariable Integer ID) {
        boolean foundDeleted = helicopterService.deleteHelicopter(ID);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
