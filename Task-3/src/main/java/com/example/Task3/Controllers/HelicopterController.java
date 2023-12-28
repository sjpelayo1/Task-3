package com.example.Task3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Task3.HelicopterService;
import com.example.Task3.Helicopter;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/helicopters")
public class HelicopterController {

    @Autowired
    private HelicopterService helicopterService;

    @GetMapping
    public ResponseEntity<Object> getAllHelicopters() {
        try {
            List<Helicopter>helicopters = helicopterService.getAllHelicopters();
            return ResponseEntity.status(HttpStatus.OK).body(helicopters);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHelicopter(@PathVariable Integer id) {
        Helicopter helicopter = helicopterService.getHelicopterById(id);

        if (helicopter != null) {
            return ResponseEntity.status(HttpStatus.OK).body(helicopter);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addHelicopter(@Valid @RequestBody Helicopter helicopter) {
        helicopterService.addHelicopter(helicopter);
        return ResponseEntity.status(HttpStatus.CREATED).body(helicopter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHelicopter(@PathVariable Integer id, @Valid @RequestBody Helicopter updatedHelicopter) {
        boolean foundUpdated = helicopterService.updateHelicopter(id, updatedHelicopter);
        if (foundUpdated) {
            Helicopter updatedIdHelicopter = helicopterService.getHelicopterById(id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdHelicopter);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHelicopter(@PathVariable Integer id) {
        boolean foundDeleted = helicopterService.deleteHelicopter(id);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
