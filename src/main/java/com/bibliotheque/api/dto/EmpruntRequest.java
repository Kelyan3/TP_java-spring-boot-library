package com.bibliotheque.api.dto;

public class EmpruntRequest {
    private Long utilisateurId;
    private Long exemplaireId;

    public Long getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(Long utilisateurId) { this.utilisateurId = utilisateurId; }

    public Long getExemplaireId() { return exemplaireId; }
    public void setExemplaireId(Long exemplaireId) { this.exemplaireId = exemplaireId; }
}
