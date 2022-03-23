package fr.ubo.dosi.CSCIEVAE;

import fr.ubo.dosi.CSCIEVAE.entity.Question;
import fr.ubo.dosi.CSCIEVAE.entity.RubriqueQuestion;
import fr.ubo.dosi.CSCIEVAE.repository.QuestionRepository;
import fr.ubo.dosi.CSCIEVAE.repository.RubriqueQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EntityScan("fr.ubo.dosi.CSCIEVAE.entity") 
public class CsciEvaeApplication implements CommandLineRunner {

	@Autowired
	RubriqueQuestionRepository rubriqueQuestionRepository;
	@Autowired
	QuestionRepository questionRepository;

	public static void main(String[] args) {
		SpringApplication.run(CsciEvaeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		questionRepository.save(
				new Question(
						23L,
						"QUS",
						null,
						11L,
						"Disponibilité de l'enseignant"

				)
		);

		List<Long> questCours = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L);
		List<Long> questTD = Arrays.asList(10L,11L,12L,5L,6L,8L);
		List<Long> questTp = Arrays.asList(13L,11L,12L,5L,6L,23L,14L);
		List<Long> questProjet = Arrays.asList(15L,16L,17L);
		List<Long> questBilan = Arrays.asList(18L,19L,20L,21L,22L);
		List<Long> questTdTp = Arrays.asList(10L,11L,12L,13L,14L,5L,6L,8L,23L);
		List<Long> questCoursTd = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L);

		questCours.forEach( coursQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
							1L,
							coursQuestId,
							questCours.indexOf(coursQuestId)+1L
					)
			);
		});
		questTD.forEach( tdQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
							3L,
							tdQuestId,
							questTD.indexOf(tdQuestId)+1L
					)
			);
		});
		questTp.forEach( tpQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
						5L,
						tpQuestId,
						questTp.indexOf(tpQuestId)+1L
					)
			);
		});
		questProjet.forEach( projQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
						6L,
						projQuestId,
						questProjet.indexOf(projQuestId)+1L
					)
			);
		});
		questBilan.forEach( bilanQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
						7L,
						bilanQuestId,
						questBilan.indexOf(bilanQuestId)+1L
					)
			);
		});
		questCoursTd.forEach( coursTdQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
							2L,
							coursTdQuestId,
							questCoursTd.indexOf(coursTdQuestId)+1L
					)
			);
		});
		questTdTp.forEach(tdTpQuestId -> {
			rubriqueQuestionRepository.save(
					new RubriqueQuestion(
							4L,
							tdTpQuestId,
							questTdTp.indexOf(tdTpQuestId)+1L
					)
			);
		});
	}
}
