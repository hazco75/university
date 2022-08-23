package com.example.university;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.university.enums.Degree;
import com.example.university.model.Course;
import com.example.university.model.Formation;
import com.example.university.model.Student;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.FormationRepository;
import com.example.university.repository.StudentRepository;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StudentRepository studentRepository, CourseRepository courseRepository, FormationRepository formationRepository) {
		return args -> {
			Stream.of("Hazco", "Blizco", "Tezco", "Kuzco", "Trazco", "Flozco", "Mezco", "Nazco", "Zizco")
			.forEach(name -> { 
				Student student = new Student(name, name + "LN", name + "gmail.com", Degree.LICENSE);
				studentRepository.save(student);
			});

			Stream.of("Tozco", "Trizco", "Cezco", "Xizco", "Mazco")
			.forEach(name -> { 
				Student student = new Student(name, name + "LN", name + "gmail.com", Degree.MASTER);
				studentRepository.save(student);
			});

			Stream.of("Pozco", "Neazco", "Lozco", "Bazco")
			.forEach(name -> { 
				Student student = new Student(name, name + "LN", name + "gmail.com", Degree.DOCTORATE);
				studentRepository.save(student);
			});

			Course courseHistoireEurope = new Course("Histoire de l'Europe", "HIST_EUR", "HIS");
			Course courseHistoireAfrique = new Course("Histoire de l'Afrique", "HIST_AFR", "HIS");
			Course courseHistoireAsie = new Course("Histoire de l'Asie", "HIST_ASIA", "HIS");
			courseRepository.saveAll(Arrays.asList(courseHistoireEurope, courseHistoireAfrique, courseHistoireAsie));

			Course courseHistoireEuropeAvance = new Course("Histoire de l'Europe Avancé", "HIST_EUR_AV", "HIS-AV");
			Course courseHistoireAfriqueAvance = new Course("Histoire de l'Afrique Avancé", "HIST_AFR_AV", "HIS-AV");
			Course courseHistoireAsieAvance = new Course("Histoire de l'Asie Avancé", "HIST_ASIA_AV", "HIS-AV");
			courseRepository.saveAll(Arrays.asList(courseHistoireEuropeAvance, courseHistoireAfriqueAvance, courseHistoireAsieAvance));

			Course courseHistoireEuropeExpert = new Course("Histoire de l'Europe Expert", "HIST_EUR_EXP", "HIS-EXP");
			Course courseHistoireAfriqueExpert = new Course("Histoire de l'Afrique Expert", "HIST_AFR_EXP", "HIS-EXP");
			Course courseHistoireAsieExpert = new Course("Histoire de l'Asie Expert", "HIST_ASIA_EXP", "HIS-EXP");
			courseRepository.saveAll(Arrays.asList(courseHistoireEuropeExpert, courseHistoireAfriqueExpert, courseHistoireAsieExpert));

			/* Stream.of("Histoire de l'Europe", "Géographie de l'Afrique", "Mathématiques générales")
			.forEach(name -> {
				Course course = new Course(name);
				courseRepository.save(course);
			}); */

			Formation formationHistoire = new Formation("Histoire", "HIS", Degree.LICENSE);
			Formation formationGeo = new Formation("Géographie", "GEO", Degree.LICENSE);
			Formation formationMaths = new Formation("Mathématiques", "MAT", Degree.LICENSE);

			Formation formationHistoireAvance = new Formation("Histoire Avance", "HIS-AV", Degree.MASTER);
			Formation formationGeoAvance = new Formation("Géographie Avance", "GEO-AV", Degree.MASTER);
			Formation formationMathsAvance = new Formation("Mathématiques Avance", "MAT-AV", Degree.MASTER);

			Formation formationHistoireExpert = new Formation("Histoire Expert", "HIS-EXP", Degree.DOCTORATE);
			Formation formationGeoExpert = new Formation("Géographie Expert", "GEO-EXP", Degree.DOCTORATE);
			Formation formationMathsExpert = new Formation("Mathématiques Expert", "MAT-EXP", Degree.DOCTORATE);

			formationRepository.saveAll(Arrays.asList(formationHistoire,formationGeo,formationMaths,
			formationHistoireAvance, formationGeoAvance, formationMathsAvance,
			formationHistoireExpert, formationGeoExpert, formationMathsExpert));
		};
	}

}
