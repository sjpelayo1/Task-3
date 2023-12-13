package com.example.Task3;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JetService {

    private List<Jet> jets = new ArrayList<>();
    private int counter = 1;

    public List<Jet> getAllJets() {
        return jets;
    }

    public Jet getJetById(int id) {
        return jets.stream()
                .filter(jet -> jet.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addJet(Jet jet) {
        jet.setId(counter);
        jets.add(jet);
        counter++;
    }

    public boolean updateJet(int id, Jet updatedJet) {
        Jet existingJet = getJetById(id);
        if (existingJet != null) {
            existingJet.setNumWings(updatedJet.getNumWings());
            existingJet.setNumEngines(updatedJet.getNumEngines());
            existingJet.setName(updatedJet.getName());

            return true;
        } else {
            return false;

        }
    }

    public boolean deleteJet(int id) {
        Jet jetToRemove = getJetById(id);
        if (jetToRemove != null) {
            jets.remove(jetToRemove);
            return true;
        } else {
            return false;
        }

    }
}