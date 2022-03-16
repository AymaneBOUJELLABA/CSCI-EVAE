package fr.ubo.dosi.CSCIEVAE.enstities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data @AllArgsConstructor @NoArgsConstructor
public class DroitId implements Serializable {

    private Long idEvaluation;
    private Long noEnseignant;
}
