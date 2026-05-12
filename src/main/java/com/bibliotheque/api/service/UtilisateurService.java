package com.bibliotheque.api.service;

import com.bibliotheque.api.entity.Utilisateur;
import com.bibliotheque.api.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Indique que cette classe est un service Spring
public class UtilisateurService {
    @Autowired    // Spring injecte automatiquement le repository
    private UtilisateurRepository utilisateurRepository;

    // Récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Récupérer un utilisateur par son ID
    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    // Créer un nouvel utilisateur
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        Utilisateur nouvUtilisateur = new Utilisateur();
        nouvUtilisateur.setNom(utilisateur.getNom());
        nouvUtilisateur.setPrenom(utilisateur.getPrenom());

        return utilisateurRepository.save(nouvUtilisateur);
    }   

    // Modifier un utilisateur existant
    public Optional<Utilisateur> updateUtilisateur(Long id, Utilisateur utilisateurModifie) {
        return utilisateurRepository.findById(id).map(utilisateurExistant -> {
            utilisateurExistant.setNom(utilisateurModifie.getNom());
            utilisateurExistant.setPrenom(utilisateurModifie.getPrenom());
            return utilisateurRepository.save(utilisateurExistant);
        });
    }

    // Supprimer un utilisateur
    public boolean deleteUtilisateur(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Rechercher des utilisateurs par nom
    public List<Utilisateur> searchUtilisateursByNom(String nom) {
        return utilisateurRepository.findByNomContainingIgnoreCase(nom);
    }

    // Rechercher des utilisateurs par prénom
    public List<Utilisateur> searchUtilisateursByPrenom(String prenom) {
        return utilisateurRepository.findByPrenomContainingIgnoreCase(prenom);
    }
}
