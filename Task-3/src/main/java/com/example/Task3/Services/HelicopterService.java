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

    public void addHelicopter(Helicopter helicopter) {
        try {
            helicopterRepository.save(helicopter);
        } catch (Exception e) {
        }

    }

    public boolean updateHelicopter(@Valid Integer ID, Helicopter updatedHelicopter) {
        try {
            Optional<Helicopter> existingHelicopterOptional = helicopterRepository.findById(ID);

            if (existingHelicopterOptional.isPresent()) {
                Helicopter existingHelicopter = existingHelicopterOptional.get();

                if (updatedHelicopter.getName() != null) {
                    existingHelicopter.setName(updatedHelicopter.getName());
                }

                if (updatedHelicopter.getNumBlades() != 0) {
                    existingHelicopter.setNumBlades(updatedHelicopter.getNumBlades());
                }

                if (updatedHelicopter.getNumEngines() != 0) {
                    existingHelicopter.setNumEngines(updatedHelicopter.getNumEngines());
                }

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
