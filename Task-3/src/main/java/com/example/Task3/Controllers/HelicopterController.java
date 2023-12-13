package com.example.taskThree.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.taskThree.HelicopterService;
import jakarta.validation.Valid;
import com.example.taskThree.Helicopter;
import java.util.List;

@RestController
@RequestMapping("/api/helicopters")
public class HelicopterController {

    @Autowired
    private HelicopterService helicopterService;

    @GetMapping
    public List<Helicopter> getAllHelicopters() {
        return helicopterService.getAllHelicopters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHelicopter(@PathVariable int id) {
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
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHelicopter(@PathVariable int id,
            @Valid @RequestBody Helicopter updatedHelicopter) {
        boolean foundUpdated = helicopterService.updateHelicopter(id, updatedHelicopter);
        if (foundUpdated) {
            Helicopter updatedIdHelicopter = helicopterService.getHelicopterById(id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdHelicopter);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHelicopter(@PathVariable int id) {
        boolean foundDeleted = helicopterService.deleteHelicopter(id);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
