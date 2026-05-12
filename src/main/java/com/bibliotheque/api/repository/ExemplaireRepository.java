package com.bibliotheque.api.repository;

import com.bibliotheque.api.entity.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
    // JpaRepository<Exemplaire, Long> signifie :
    //   - Exemplaire → le type de l'entité gérée
    //   - Long       → le type de la clé primaire (id)

    // Spring génère automatiquement les méthodes suivantes :
    //   findAll()         → récupère tous les exemplaires
    //   findById(id)      → récupère un exemplaire par son id
    //   save(exemplaire)  → sauvegarde ou met à jour un exemplaire
    //   deleteById(id)    → supprime un exemplaire par son id
    //   existsById(id)    → vérifie si un exemplaire existe

    // Vous pouvez aussi définir vos propres requêtes
    // Spring les génère automatiquement à partir du nom de la méthode !
    List<Exemplaire> findByEtat(Exemplaire.Etat etat);
    List<Exemplaire> findByDisponible(boolean disponible);
}
