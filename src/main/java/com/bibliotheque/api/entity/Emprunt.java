package com.bibliotheque.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity                    // Indique que cette classe est une table en BDD
@Table(name = "emprunts")    // Nom de la table
@Data                      // Lombok : génère getters, setters, toString, equals, hashCode
@NoArgsConstructor         // Lombok : génère le constructeur sans paramètres
@AllArgsConstructor        // Lombok : génère le constructeur avec tous les paramètres
public class Emprunt {
    
    @Id                                                    // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Auto-incrément
    private Long id;

    // Relations
    @ManyToOne
    @JoinColumn(name = "num_adherent")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "exemplaire_id")
    private Exemplaire exemplaire;
}
