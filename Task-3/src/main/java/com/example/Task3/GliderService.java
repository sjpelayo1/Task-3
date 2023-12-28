package com.example.Task3;

import org.springframework.stereotype.Service;
import com.example.Task3.Repositories.GliderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class GliderService {

    private final GliderRepository gliderRepository;

    @Autowired
    public GliderService(GliderRepository gliderRepository) {
        this.gliderRepository = gliderRepository;
    }

    public List<Glider> getAllGliders() {
        try {
            return gliderRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Glider getGliderById(Integer id) {
        return gliderRepository.findById(id).orElse(null);
    }

    public void addGlider(Glider glider) {
        try {
            gliderRepository.save(glider);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean updateGlider(Integer id, Glider updatedGlider) {
        try {
            if (gliderRepository.existsById(id)) {
                updatedGlider.setId(id);
                gliderRepository.save(updatedGlider);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteGlider(Integer id) {
        try {
            if (gliderRepository.existsById(id)) {
                gliderRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
