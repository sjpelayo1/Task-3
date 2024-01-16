package com.example.Task3.Services;

import org.springframework.stereotype.Service;

import com.example.Task3.Models.Jet;
import com.example.Task3.Repositories.JetRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class JetService {

    private final JetRepository jetRepository;

    @Autowired
    public JetService(JetRepository jetRepository) {
        this.jetRepository = jetRepository;
    }

    public List<Jet> getAllJets() {
        return jetRepository.findAll();
    }

    public Jet getJetById(Integer ID) {
        return jetRepository.findById(ID).orElse(null);
    }

    public boolean addJet(@Valid Jet jet) {
        try {
            jetRepository.save(jet);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean updateJet(@Valid Integer ID, Jet updatedJet) {
        try {
            Optional<Jet> existingJetOptional = jetRepository.findById(ID);

            if (existingJetOptional.isPresent()) {
                Jet existingJet = existingJetOptional.get();
                    existingJet.setName(updatedJet.getName());
                    existingJet.setNumWings(updatedJet.getNumWings());
                    existingJet.setNumEngines(updatedJet.getNumEngines());
                    jetRepository.save(existingJet);
                    return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean deleteJet(Integer ID) {
        try {
            if (jetRepository.existsById(ID)) {
                jetRepository.deleteById(ID);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}