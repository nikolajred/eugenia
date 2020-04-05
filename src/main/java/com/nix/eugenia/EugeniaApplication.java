package com.nix.eugenia;

		import org.modelmapper.ModelMapper;
		import org.modelmapper.convention.MatchingStrategies;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
		import org.springframework.boot.web.client.RestTemplateBuilder;
		import org.springframework.context.annotation.Bean;
		import org.springframework.web.client.RestTemplate;

		import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class EugeniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EugeniaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.setFieldAccessLevel(PRIVATE);
		return mapper;
	}

}
