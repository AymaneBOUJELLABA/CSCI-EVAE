package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RUBRIQUE_EVALUATION")
@AllArgsConstructor
@NoArgsConstructor

@Getter @Setter

@ToString

public class RubriqueEvaluation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_RUBRIQUE_EVALUATION")
    private Long idRubriqueEvaluation;

    @Column(name = "ID_EVALUATION")
    private Long idEvaluation;

    @Column(name = "ID_RUBRIQUE")
    private Long idRubrique;

    @Column(name = "ORDRE")
    private Long ordre;

    @Column(name = "DESIGNATION")
    private String designation;


    
   // public RubriqueEvaluation() {}
  /*  public RubriqueEvaluation(Long idRubriqueEvaluation,Long idEvaluation,Long idRubrique,Long ordre,String designation) {
    	this.idRubriqueEvaluation = idRubriqueEvaluation;
    	this.idEvaluation = idEvaluation;
    	this.idRubrique= idRubrique;
    	this.ordre = ordre;
    	this.designation= designation;
    	
    }*/


}
