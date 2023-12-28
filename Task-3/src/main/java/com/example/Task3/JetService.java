package com.example.Task3;

import org.springframework.stereotype.Service;

import com.example.Task3.Repositories.JetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class JetService {

    private final JetRepository jetRepository;

    @Autowired
    public JetService(JetRepository jetRepository) {
        this.jetRepository = jetRepository;
    }

    public List<Jet> getAllJets() {
        try {
            return jetRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Jet getJetById(Integer id) {
        return jetRepository.findById(id).orElse(null);
    }

    public void addJet(Jet jet) {
        try {
            jetRepository.save(jet);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean updateJet(Integer id, Jet updatedJet) {
        try {
            if (jetRepository.existsById(id)) {
                updatedJet.setId(id);
                jetRepository.save(updatedJet);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteJet(Integer id) {
        try {
            if (jetRepository.existsById(id)) {
                jetRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}