package com.example.taskThree.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.taskThree.GliderService;
import jakarta.validation.Valid;
import com.example.taskThree.Glider;
import java.util.List;

@RestController
@RequestMapping("/api/gliders")
public class GliderController {

    @Autowired
    private GliderService gliderService;

    @GetMapping
    public List<Glider> getAllGliders() {
        return gliderService.getAllGliders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGlider(@PathVariable int id) {
        Glider glider = gliderService.getGliderById(id);

        if (glider != null) {
            return ResponseEntity.status(HttpStatus.OK).body(glider);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addGlider(@Valid @RequestBody Glider glider) {
        gliderService.addGlider(glider);
        return ResponseEntity.status(HttpStatus.CREATED).body(glider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGlider(@PathVariable int id, @Valid @RequestBody Glider updatedGlider) {
        boolean foundUpdated = gliderService.updateGlider(id, updatedGlider);
        if (foundUpdated) {
            Glider updatedIdGlider = gliderService.getGliderById(id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdGlider);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGlider(@PathVariable int id) {
        boolean foundDeleted = gliderService.deleteGlider(id);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

