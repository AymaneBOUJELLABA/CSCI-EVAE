package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "QUALIFICATIF")

public class Qualificatif implements Serializable {
    @Id
    @Column(name = "ID_QUALIFICATIF")
    private Long idQualificatif;

    @Column(name = "MAXIMAL")
    private String maximal;

    @Column(name = "MINIMAL")
    private String minimal;

    public Long getIdQualificatif() {
        return this.idQualificatif;
    }

    public void setIdQualificatif(Long idQualificatif) {
        this.idQualificatif = idQualificatif;
    }

    public String getMaximal() {
        return this.maximal;
    }

    public void setMaximal(String maximal) {
        this.maximal = maximal;
    }

    public String getMinimal() {
        return this.minimal;
    }

    public void setMinimal(String minimal) {
        this.minimal = minimal;
    }
}
