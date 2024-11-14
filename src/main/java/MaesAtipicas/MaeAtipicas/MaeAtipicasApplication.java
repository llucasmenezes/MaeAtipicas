package MaesAtipicas.MaeAtipicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "MaesAtipicas/MaeAtipicas/model")
public class MaeAtipicasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaeAtipicasApplication.class, args);
	}

}
