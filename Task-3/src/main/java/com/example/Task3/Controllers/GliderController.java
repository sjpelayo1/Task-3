package com.example.Task3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Task3.Models.Glider;
import com.example.Task3.Services.GliderService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/gliders")
public class GliderController {

    @Autowired
    private GliderService gliderService;

    @GetMapping
    public ResponseEntity<Object> getAllGliders() {
        List<Glider> gliders = gliderService.getAllGliders();
        return ResponseEntity.status(HttpStatus.OK).body(gliders);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<Object> getGlider(@PathVariable Integer ID) {
        Glider glider = gliderService.getGliderById(ID);

        if (glider != null) {
            return ResponseEntity.status(HttpStatus.OK).body(glider);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addGlider(@Valid @RequestBody Glider glider) {
        try {
            gliderService.addGlider(glider);
            return ResponseEntity.status(HttpStatus.CREATED).body(glider);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation errors");
        }
    }

    @PutMapping("/{ID}")
    public ResponseEntity<Object> updateGlider(@PathVariable Integer ID, @Valid @RequestBody Glider updatedGlider) {
        boolean foundUpdated = gliderService.updateGlider(ID, updatedGlider);
        if (foundUpdated) {
            Glider updatedIdGlider = gliderService.getGliderById(ID);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdGlider);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<Object> deleteGlider(@PathVariable Integer ID) {
        boolean foundDeleted = gliderService.deleteGlider(ID);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
