INSERT INTO auteurs (nom, prenom) VALUES ('Tolkien', 'J.R.R.');
INSERT INTO auteurs (nom, prenom) VALUES ('Kishimoto', 'Masashi');
INSERT INTO auteurs (nom, prenom) VALUES ('Baudelaire', 'Charles');
INSERT INTO auteurs (nom, prenom) VALUES ('Goscinny', 'René');

INSERT INTO livres (titre, isbn, categorie, auteur_id) VALUES ('Le Seigneur des Anneaux', '978-2-07-061190-3', 'ROMAN', 1);
INSERT INTO livres (titre, isbn, categorie, auteur_id) VALUES ('Naruto Vol.1', '978-2-87-128280-2', 'MANGA', 2);
INSERT INTO livres (titre, isbn, categorie, auteur_id) VALUES ('Les Fleurs du Mal', '978-2-07-036024-3', 'POESIE', 3);
INSERT INTO livres (titre, isbn, categorie, auteur_id) VALUES ('Astérix le Gaulois', '978-2-86-497001-9', 'COMEDIE', 4);

INSERT INTO exemplaires (livre_id, etat, disponible) VALUES (1, 'NEUF', true);
INSERT INTO exemplaires (livre_id, etat, disponible) VALUES (2, 'BON', true);
INSERT INTO exemplaires (livre_id, etat, disponible) VALUES (3, 'ABIME', false);
INSERT INTO exemplaires (livre_id, etat, disponible) VALUES (4, 'NEUF', true);

INSERT INTO utilisateurs (nom, prenom) VALUES ('Dupont', 'Jean');
INSERT INTO utilisateurs (nom, prenom) VALUES ('Lumdupen', 'Jordan');
INSERT INTO utilisateurs (nom, prenom) VALUES ('Alfes', 'Kevin');
INSERT INTO utilisateurs (nom, prenom) VALUES ('Algoro', 'Samuel');

INSERT INTO emprunts (num_adherent, exemplaire_id) VALUES (1, 1);
INSERT INTO emprunts (num_adherent, exemplaire_id) VALUES (3, 2);
INSERT INTO emprunts (num_adherent, exemplaire_id) VALUES (2, 3);
INSERT INTO emprunts (num_adherent, exemplaire_id) VALUES (4, 4);