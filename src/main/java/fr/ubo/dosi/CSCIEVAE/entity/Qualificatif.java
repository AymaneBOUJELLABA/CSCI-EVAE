package fr.ubo.dosi.CSCIEVAE.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "QUALIFICATIF")


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter

public class Qualificatif implements Serializable {
    @Id
    @Column(name = "ID_QUALIFICATIF")
    private Long idQualificatif;

    @Column(name = "MAXIMAL")
    private String maximal;

    @Column(name = "MINIMAL")
    private String minimal;

}
