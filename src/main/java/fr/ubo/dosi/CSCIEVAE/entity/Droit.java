package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DROIT")
@IdClass(DroitId.class)
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Droit implements Serializable {
    @Id
    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;

    @Id
    @Column(name = "NO_ENSEIGNANT")
    private Long noEnseignant;

    @Column(name = "CONSULTATION", columnDefinition = "CHAR")
    private String consultation;

    @Column(name = "DUPLICATION", columnDefinition = "CHAR")
    private String duplication;
   
}
