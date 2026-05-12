package com.bibliotheque.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity                    // Indique que cette classe est une table en BDD
@Table(name = "exemplaires")    // Nom de la table
@Data                      // Lombok : génère getters, setters, toString, equals, hashCode
@NoArgsConstructor         // Lombok : génère le constructeur sans paramètres
@AllArgsConstructor        // Lombok : génère le constructeur avec tous les paramètres
public class Exemplaire {

    @Id                                                    // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Auto-incrément
    private Long id;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    // Enumération des états possibles pour un exemplaire.
    public enum Etat {
        NEUF, BON, ABIME
    }

    @Column(nullable = false)
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "livre_id", nullable = false)    // Clé étrangère vers la table "livres"
    private Livre livre;
}
