package artur.springframework.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("springdatajpa")
public class SfgPetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfgPetClinicApplication.class, args);
	}

}
