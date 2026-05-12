package com.bibliotheque.api.repository;

import com.bibliotheque.api.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // JpaRepository<Utilisateur, Long> signifie :
    //   - Utilisateur   → le type de l'entité gérée
    //   - Long          → le type de la clé primaire (numAdherent)

    // Spring génère automatiquement les méthodes suivantes :
    //   findAll()         → récupère tous les utilisateurs
    //   findById(id)      → récupère un utilisateur par son numAdherent
    //   save(utilisateur) → sauvegarde ou met à jour un utilisateur
    //   deleteById(id)    → supprime un utilisateur par son numAdherent
    //   existsById(id)    → vérifie si un utilisateur existe

    // Vous pouvez aussi définir vos propres requêtes
    // Spring les génère automatiquement à partir du nom de la méthode !
    List<Utilisateur> findByNomContainingIgnoreCase(String nom);
    List<Utilisateur> findByPrenomContainingIgnoreCase(String prenom);
}
