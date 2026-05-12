package com.bibliotheque.api.repository;

import com.bibliotheque.api.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    // JpaRepository<Emprunt, Long> signifie :
    //   - Emprunt → le type de l'entité gérée
    //   - Long    → le type de la clé primaire (id)

    // Spring génère automatiquement les méthodes suivantes :
    //   findAll()         → récupère tous les emprunts
    //   findById(id)      → récupère un emprunt par son id
    //   save(emprunt)     → sauvegarde ou met à jour un emprunt
    //   deleteById(id)    → supprime un emprunt par son id
    //   existsById(id)    → vérifie si un emprunt existe

    // Vous pouvez aussi définir vos propres requêtes
    // Spring les génère automatiquement à partir du nom de la méthode !
    List<Emprunt> findByUtilisateurNumAdherent(Long numAdherent);
    List<Emprunt> findByExemplaireId(Long exemplaireId);
}
