package com.bibliotheque.api.service;

import com.bibliotheque.api.entity.Auteur;
import com.bibliotheque.api.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Indique que cette classe est un service Spring
public class AuteurService {

    @Autowired    // Spring injecte automatiquement le repository
    private AuteurRepository auteurRepository;

    // Récupérer tous les auteurs
    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    // Récupérer un auteur par son ID
    public Optional<Auteur> getAuteurById(Long id) {
        return auteurRepository.findById(id);
    }

    // Créer un nouvel auteur
    public Auteur createAuteur(Auteur auteur) {
        // Règle métier : le nom et prénom doivent être uniques ensemble
        // (vous pouvez ajouter des validations ici)
        return auteurRepository.save(auteur);
    }

    // Modifier un auteur existant
    public Optional<Auteur> updateAuteur(Long id, Auteur auteurModifie) {
        return auteurRepository.findById(id).map(auteurExistant -> {
            auteurExistant.setNom(auteurModifie.getNom());
            auteurExistant.setPrenom(auteurModifie.getPrenom());
            return auteurRepository.save(auteurExistant);
        });
    }

    // Supprimer un auteur
    public boolean deleteAuteur(Long id) {
        if (auteurRepository.existsById(id)) {
            auteurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Rechercher des auteurs par nom
    public List<Auteur> searchByNom(String nom) {
        return auteurRepository.findByNomContainingIgnoreCase(nom);
    }

    // Rechercher des auteurs par prénom
    public List<Auteur> searchByPrenom(String prenom) {
        return auteurRepository.findByPrenomContainingIgnoreCase(prenom);
    }
}