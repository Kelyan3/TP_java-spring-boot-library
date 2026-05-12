package com.bibliotheque.api.controller;

import com.bibliotheque.api.entity.Utilisateur;
import com.bibliotheque.api.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController               // Indique que cette classe est un controller REST
@RequestMapping("/api/utilisateurs") // Préfixe de toutes les routes de ce controller
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateurService;

    // GET /api/utilisateurs → Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);    // HTTP 200 + liste des utilisateurs en JSON
    }

    // GET /api/utilisateurs/{id} → Récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id)
                .map(utilisateur -> ResponseEntity.ok(utilisateur))           // HTTP 200 si trouvé
                .orElse(ResponseEntity.notFound().build());         // HTTP 404 si non trouvé
    }

    // POST /api/utilisateurs → Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur nouvelUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelUtilisateur);  // HTTP 201
    }

    // PUT /api/utilisateurs/{id} → Modifier un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id,
                                              @RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUtilisateur(id, utilisateur)
                .map(utilisateurModifie -> ResponseEntity.ok(utilisateurModifie))
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/utilisateurs/{id} → Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        if (utilisateurService.deleteUtilisateur(id)) {
            return ResponseEntity.noContent().build();    // HTTP 204 : succès sans contenu
        }
        return ResponseEntity.notFound().build();         // HTTP 404 si non trouvé
    }

    // GET /api/utilisateurs/search?nom=dupont → Rechercher par nom
    @GetMapping("/search")
    public ResponseEntity<List<Utilisateur>> searchUtilisateursByNom(@RequestParam String nom) {
        List<Utilisateur> utilisateurs = utilisateurService.searchUtilisateursByNom(nom);
        return ResponseEntity.ok(utilisateurs);    // HTTP 200 + liste des utilisateurs trouvés
    }
}
