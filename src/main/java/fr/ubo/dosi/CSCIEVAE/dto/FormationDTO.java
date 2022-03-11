package fr.ubo.dosi.CSCIEVAE.dto;

public class FormationDTO {
    private String codeFormation;
    private String diplome;
    private Long n0Annee;
    private String nomFormation;
    private String doubleDiplome;
    private java.sql.Date debutAccreditation;
    private java.sql.Date finAccreditation;

    public String getCodeFormation() {
        return this.codeFormation;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Long getN0Annee() {
        return this.n0Annee;
    }

    public void setN0Annee(Long n0Annee) {
        this.n0Annee = n0Annee;
    }

    public String getNomFormation() {
        return this.nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public String getDoubleDiplome() {
        return this.doubleDiplome;
    }

    public void setDoubleDiplome(String doubleDiplome) {
        this.doubleDiplome = doubleDiplome;
    }

    public java.sql.Date getDebutAccreditation() {
        return this.debutAccreditation;
    }

    public void setDebutAccreditation(java.sql.Date debutAccreditation) {
        this.debutAccreditation = debutAccreditation;
    }

    public java.sql.Date getFinAccreditation() {
        return this.finAccreditation;
    }

    public void setFinAccreditation(java.sql.Date finAccreditation) {
        this.finAccreditation = finAccreditation;
    }
}
