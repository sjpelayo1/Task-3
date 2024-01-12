package com.example.Task3.Services;

import org.springframework.stereotype.Service;

import com.example.Task3.Models.Glider;
import com.example.Task3.Repositories.GliderRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Service
public class GliderService {

    private final GliderRepository gliderRepository;

    @Autowired
    public GliderService(GliderRepository gliderRepository) {
        this.gliderRepository = gliderRepository;
    }

    public List<Glider> getAllGliders() {
        return gliderRepository.findAll();
    }

    public Glider getGliderById(Integer ID) {
        return gliderRepository.findById(ID).orElse(null);
    }

    public void addGlider(@Valid Glider glider) {
        try {
            gliderRepository.save(glider);
        } catch (Exception e) {
        }

    }

    public boolean updateGlider(@Valid Integer ID, Glider updatedGlider) {
        try {
            Optional<Glider> existingGliderOptional = gliderRepository.findById(ID);

            if (existingGliderOptional.isPresent()) {
                Glider existingGlider = existingGliderOptional.get();

                if (updatedGlider.getName() != null) {
                    existingGlider.setName(updatedGlider.getName());
                }

                if (updatedGlider.getNumWings() != 0) {
                    existingGlider.setNumWings(updatedGlider.getNumWings());
                }

                gliderRepository.save(existingGlider);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteGlider(Integer ID) {
        try {
            if (gliderRepository.existsById(ID)) {
                gliderRepository.deleteById(ID);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
