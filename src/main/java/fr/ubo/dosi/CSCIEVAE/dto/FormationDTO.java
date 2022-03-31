
package fr.ubo.dosi.CSCIEVAE.dto;


import fr.ubo.dosi.CSCIEVAE.entity.Qualificatif;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class FormationDTO {
    private String codeFormation;
    private String diplome;
    private Long n0Annee;
    private String nomFormation;
    private String doubleDiplome;
    private java.sql.Date debutAccreditation;
    private java.sql.Date finAccreditation;

   
}


