package com.example.Task3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            if(gliders.size() != 0) {
                return ResponseEntity.status(HttpStatus.OK).body(gliders);
            } else if(gliders.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(gliders);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gliders);
            }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getGlider(@PathVariable Integer id) {
        Glider glider = gliderService.getGliderById(id);

        if (glider != null) {
            return ResponseEntity.status(HttpStatus.OK).body(glider);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(glider);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addGlider(@Valid @RequestBody Glider glider) {
        gliderService.addGlider(glider);
        if(glider != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(glider);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(glider);

        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateGlider(@PathVariable Integer id, @Valid @RequestBody Glider updatedGlider) {
        boolean foundUpdated = gliderService.updateGlider(id, updatedGlider);
        if (foundUpdated) {
            Glider updatedIdGlider = gliderService.getGliderById(id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdGlider);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGlider(@PathVariable Integer id) {
        boolean foundDeleted = gliderService.deleteGlider(id);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
