package com.example.Task3;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelicopterService {

    private List<Helicopter> helicopters = new ArrayList<>();
    private int counter = 1;

    public List<Helicopter> getAllHelicopters() {
        return helicopters;
    }

    public Helicopter getHelicopterById(int id) {
        return helicopters.stream()
                .filter(helicopter -> helicopter.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addHelicopter(Helicopter helicopter) {
        helicopter.setId(counter);
        helicopters.add(helicopter);
        counter++;
    }

    public boolean updateHelicopter(int id, Helicopter updatedHelicopter) {
        Helicopter existingHelicopter = getHelicopterById(id);
        if (existingHelicopter != null) {
            existingHelicopter.setNumBlades(updatedHelicopter.getNumBlades());
            existingHelicopter.setNumEngines(updatedHelicopter.getNumEngines());
            existingHelicopter.setName(updatedHelicopter.getName());

            return true;
        } else {
            return false;

        }
    }

    public boolean deleteHelicopter(int id) {
        Helicopter helicopterToRemove = getHelicopterById(id);
        if (helicopterToRemove != null) {
            helicopters.remove(helicopterToRemove);
            return true;
        } else {
            return false;
        }

    }
}