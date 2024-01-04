package com.example.Task3.Services;

import org.springframework.stereotype.Service;

import com.example.Task3.Models.Helicopter;
import com.example.Task3.Repositories.HelicopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class HelicopterService {

    private final HelicopterRepository helicopterRepository;

    @Autowired
    public HelicopterService(HelicopterRepository helicopterRepository) {
        this.helicopterRepository = helicopterRepository;
    }

    public List<Helicopter> getAllHelicopters() {
        try {
            return helicopterRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Helicopter getHelicopterById(Integer id) {
        return helicopterRepository.findById(id).orElse(null);
    }

    public void addHelicopter(Helicopter helicopter) {
        try {
            helicopterRepository.save(helicopter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean updateHelicopter(Integer id, Helicopter updatedHelicopter) {
        try {
            if (helicopterRepository.existsById(id)) {
                updatedHelicopter.setId(id);
                helicopterRepository.save(updatedHelicopter);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteHelicopter(Integer id) {
        try {
            if (helicopterRepository.existsById(id)) {
                helicopterRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
