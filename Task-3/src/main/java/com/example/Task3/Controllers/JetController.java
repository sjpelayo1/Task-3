package com.example.Task3.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Task3.Models.Glider;
import com.example.Task3.Models.Jet;
import com.example.Task3.Services.JetService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/jets")
public class JetController {

    @Autowired
    private JetService jetService;

    @GetMapping
    public ResponseEntity<Object> getAllJets() {
        List<Jet> jets = jetService.getAllJets();
            if(jets.size() != 0) {
                return ResponseEntity.status(HttpStatus.OK).body(jets);
            }
            else if(jets.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(jets);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jets);
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getJet(@PathVariable Integer id) {
        Jet jet = jetService.getJetById(id);

        if (jet != null) {
            return ResponseEntity.status(HttpStatus.OK).body(jet);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addJet(@Valid @RequestBody Jet jet) {
        jetService.addJet(jet);
        return ResponseEntity.status(HttpStatus.CREATED).body(jet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJet(@PathVariable Integer id, @Valid @RequestBody Jet updatedJet) {
        boolean foundUpdated = jetService.updateJet(id, updatedJet);
        if (foundUpdated) {
            Jet updatedIdJet = jetService.getJetById(id);
            return ResponseEntity.status(HttpStatus.OK).body(updatedIdJet);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJet(@PathVariable Integer id) {
        boolean foundDeleted = jetService.deleteJet(id);
        if (foundDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

