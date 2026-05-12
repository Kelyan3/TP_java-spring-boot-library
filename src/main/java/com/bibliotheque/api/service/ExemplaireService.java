package com.bibliotheque.api.service;

import com.bibliotheque.api.entity.Exemplaire;
import com.bibliotheque.api.repository.ExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Indique que cette classe est un service Spring
public class ExemplaireService {
    @Autowired    // Spring injecte automatiquement le repository
    private ExemplaireRepository exemplaireRepository;

    // Récupérer tous les exemplaires
    public List<Exemplaire> getAllExemplaires() {
        return exemplaireRepository.findAll();
    }

    // Récupérer un exemplaire par son ID
    public Optional<Exemplaire> getExemplaireById(Long id) {
        return exemplaireRepository.findById(id);
    }

    // Créer un nouvel exemplaire
    public Exemplaire createExemplaire(Exemplaire exemplaire) {
        Exemplaire nouvExemplaire = new Exemplaire();
        nouvExemplaire.setEtat(exemplaire.getEtat());
        nouvExemplaire.setDisponible(exemplaire.isDisponible());
        return exemplaireRepository.save(nouvExemplaire);
    }

    // Modifier un exemplaire existant
    public Optional<Exemplaire> updateExemplaire(Long id, Exemplaire exemplaireModifie) {
        return exemplaireRepository.findById(id).map(exemplaireExistant -> {
            exemplaireExistant.setEtat(exemplaireModifie.getEtat());
            exemplaireExistant.setDisponible(exemplaireModifie.isDisponible());
            return exemplaireRepository.save(exemplaireExistant);
        });
    }

    // Supprimer un exemplaire
    public boolean deleteExemplaire(Long id) {
        if (exemplaireRepository.existsById(id)) {
            exemplaireRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Filtrer les exemplaires par état
    public List<Exemplaire> filterExemplairesByEtat(Exemplaire.Etat etat) {
        return exemplaireRepository.findByEtat(etat);
    }

    // Filtrer les exemplaires par disponibilité
    public List<Exemplaire> filterExemplairesByDisponibilite(boolean disponible) {
        return exemplaireRepository.findByDisponible(disponible);
    }
}
