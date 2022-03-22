package fr.ubo.dosi.CSCIEVAE.messages;

import lombok.Data;

@Data
public class RubriqueOrdreUpdateMessage
{
	private Long idRubrique;
	private Long ordre;
	
	public RubriqueOrdreUpdateMessage(Long id, Long ordre)
	{
		this.idRubrique = id;
		this.ordre = ordre;
	}
}
