<<<<<<< HEAD:src/main/java/fr/ubo/dosi/CSCIEVAE/enstities/RubriqueQuestion.java
package fr.ubo.dosi.CSCIEVAE.enstities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RUBRIQUE_QUESTION")
public class RubriqueQuestion implements Serializable {
    @Id
    @Column(name = "ID_RUBRIQUE")
    private Long idRubrique;

    @Id
    @Column(name = "ID_QUESTION")
    private Long idQuestion;

    @Column(name = "ORDRE")
    private Long ordre;

    public Long getIdRubrique() {
        return this.idRubrique;
    }

    public void setIdRubrique(Long idRubrique) {
        this.idRubrique = idRubrique;
    }

    public Long getIdQuestion() {
        return this.idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Long getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }
}
=======
package fr.ubo.dosi.CSCIEVAE.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RUBRIQUE_QUESTION")
public class RubriqueQuestion implements Serializable {
    @Id
    @Column(name = "ID_RUBRIQUE")
    private Long idRubrique;

    @Id
    @Column(name = "ID_QUESTION")
    private Long idQuestion;

    @Column(name = "ORDRE")
    private Long ordre;

    public Long getIdRubrique() {
        return this.idRubrique;
    }

    public void setIdRubrique(Long idRubrique) {
        this.idRubrique = idRubrique;
    }

    public Long getIdQuestion() {
        return this.idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Long getOrdre() {
        return this.ordre;
    }

    public void setOrdre(Long ordre) {
        this.ordre = ordre;
    }
}
>>>>>>> master:src/main/java/fr/ubo/dosi/CSCIEVAE/entity/RubriqueQuestion.java
