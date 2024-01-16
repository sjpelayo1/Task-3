package com.example.Task3.Services;

import org.springframework.stereotype.Service;

import com.example.Task3.Models.Helicopter;
import com.example.Task3.Repositories.HelicopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

@Service
public class HelicopterService {

    private final HelicopterRepository helicopterRepository;

    @Autowired
    public HelicopterService(HelicopterRepository helicopterRepository) {
        this.helicopterRepository = helicopterRepository;
    }

    public List<Helicopter> getAllHelicopters() {
        return helicopterRepository.findAll();

    }

    public Helicopter getHelicopterById(Integer ID) {
        return helicopterRepository.findById(ID).orElse(null);
    }

    public boolean addHelicopter(@Valid Helicopter helicopter) {
        try {
            helicopterRepository.save(helicopter);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean updateHelicopter(@Valid Integer ID, Helicopter updatedHelicopter) {
        try {
            Optional<Helicopter> existingHelicopterOptional = helicopterRepository.findById(ID);

            if (existingHelicopterOptional.isPresent()) {
                Helicopter existingHelicopter = existingHelicopterOptional.get();
                    existingHelicopter.setName(updatedHelicopter.getName());
                    existingHelicopter.setNumBlades(updatedHelicopter.getNumBlades());
                    existingHelicopter.setNumEngines(updatedHelicopter.getNumEngines());
                    helicopterRepository.save(existingHelicopter);
                    return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteHelicopter(Integer ID) {
        try {
            if (helicopterRepository.existsById(ID)) {
                helicopterRepository.deleteById(ID);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
