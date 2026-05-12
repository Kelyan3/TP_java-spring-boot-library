package com.bibliotheque.api.service;

import com.bibliotheque.api.dto.EmpruntRequest;
import com.bibliotheque.api.entity.Emprunt;
import com.bibliotheque.api.repository.EmpruntRepository;
import com.bibliotheque.api.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Indique que cette classe est un service Spring
public class EmpruntService {

    @Autowired    // Spring injecte automatiquement les repositories nécessaires
    private EmpruntRepository empruntRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ExemplaireService exemplaireService;

    // Récupérer tous les emprunts.
    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    // Récupérer un emprunt par son ID.
    public Optional<Emprunt> getEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }

    // Créer un nouvel emprunt.
    public Emprunt createEmprunt(EmpruntRequest request) {
        Emprunt emprunt = new Emprunt();
        emprunt.setUtilisateur(utilisateurRepository.findById(request.getUtilisateurId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable avec l'id : " + request.getUtilisateurId())));
        emprunt.setExemplaire(exemplaireService.getExemplaireById(request.getExemplaireId())
                .orElseThrow(() -> new IllegalArgumentException("Exemplaire introuvable avec l'id : " + request.getExemplaireId())));
        return empruntRepository.save(emprunt);
    }

    // Modifier un emprunt existant.
    public Optional<Emprunt> updateEmprunt(Long id, Emprunt empruntModifie) {
        return empruntRepository.findById(id).map(empruntExistant -> {
            empruntExistant.setUtilisateur(empruntModifie.getUtilisateur());
            empruntExistant.setExemplaire(empruntModifie.getExemplaire());
            return empruntRepository.save(empruntExistant);
        });
    }

    // Supprimer un emprunt par son ID.
    public boolean deleteEmprunt(Long id) {
        if (empruntRepository.existsById(id)) {
            empruntRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Filtrer les emprunts par ID d'utilisateur.
    public List<Emprunt> filterEmpruntsByUtilisateurNumAdherent(Long numAdherent) {
        return empruntRepository.findByUtilisateurNumAdherent(numAdherent);
    }

    // Filtrer les emprunts par ID d'exemplaire.
    public List<Emprunt> filterEmpruntsByExemplaireId(Long exemplaireId) {
        return empruntRepository.findByExemplaireId(exemplaireId);
    }
}
